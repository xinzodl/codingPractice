package com.xinzodl.code.tetra

import com.xinzodl.code.tetra.Post.uri
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClientBuilder
import io.lemonlabs.uri.Url

import scala.io.{BufferedSource, Source}
import org.joda.time.DateTime

object ParseLogs {

    private case class Message(time: DateTime, to: Int, from: Int, text: String)
    private case class Text(time: DateTime, to: Int, from: Int, unidad: Int, informe: Int, inicial: String, hora: String, distrito: Int, direccion: String, info: String)

    private val mesg2TimeStr: Message => String =  m => m.time.toString

    private val filePath = ""
    private val containsTEXTregex = "(.+) - SSI:([0-9]+)(.+)Party_SSI:([0-9]+)(.+)TEXT:'(.+)".r
    private val textRegex = "([0-9]+) / ([0-9]+) / ([0-9\\.]+) / ([0-9:]+) / ([0-9]+) / (.[^/]+) / (.+)".r
    private val containsDATAregex = "(DATA:.+)"
    private val date = "2021-04-21"

    private def mapLines2Message (lines: Iterator[String]): Iterator[Option[Message]] = {
        lines.map {
            case containsTEXTregex(time, to, _, from, _, text) =>
                Some(Message(
                    new DateTime(s"${date}T$time"),
                    to.toInt,
                    from.toInt,
                    text.replaceAll(containsDATAregex, "").strip()
                ))
            case _: String => None
        }
    }

    private def listMessage2ListText(lm: List[Message]): List[Text] = {
        lm.map { x => x.text match {
            case textRegex(unidad, informe, inicial, hora, distrito, direccion, info) =>
                Some(Text(x.time, x.to, x.from, unidad.toInt, informe.toInt, inicial, hora, distrito.toInt, direccion, info))
            case _: String => None
        }}.filter(_.isDefined).map(_.get)
    }

    private def dropDuplicates(im: Iterator[Message]): List[Message] = {
        im.toList.groupBy(_.text).map( _._2.minBy(mesg2TimeStr)).toList.sortBy(mesg2TimeStr)
    }

    private def sendMessage(msg: String): Unit = {
        val botToken = ""
        val chatId = ""
        val text = Url.parse(msg).toString()
        val uri = s"https://api.telegram.org/bot$botToken/sendMessage?chat_id=-$chatId&text=$text"
//        println(uri)
        val post = new HttpPost(uri)
        Thread.sleep(3000)
        HttpClientBuilder.create.build.execute(post).close()
    }

    def main(args: Array[String]): Unit = {
        // Read from file
        val bufferedSource: BufferedSource = Source.fromFile(filePath)
        val lines = bufferedSource.getLines()

        // Parse messages
        val linesSplitByTime = mapLines2Message(lines)

        // Get all valid messages
        val validMessages = linesSplitByTime.filter(_.isDefined).map(_.get)

        // Drop duplicates (choose the one with lowest timestamp)
        val messagesWithNoDuplicates = dropDuplicates(validMessages)

        // Pretty Print
        val messagesWithNewAvisos = listMessage2ListText(messagesWithNoDuplicates)
        val prettyPrint = messagesWithNewAvisos.map( m => s"La unidad ${m.unidad} se dirige a un ${m.inicial} en ${m.direccion} con los datos: ${m.info}")

        // Send message
        prettyPrint.foreach(sendMessage)
//        println(prettyPrint.mkString("\n"))

        // Close reader
        bufferedSource.close()
    }

}
