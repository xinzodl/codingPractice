package com.xinzodl.code.underscore.slick

import com.typesafe.config.{Config, ConfigFactory}
import slick.jdbc.MySQLProfile.api._

import java.util
import java.util.concurrent.TimeUnit
import scala.collection.JavaConverters._
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._


case class TestRecord(ID: Int, message: String, unit: Int)

class TestTable(tag: Tag) extends Table[TestRecord](tag, None, "test") {
  val message: Rep[String] = column[String]("message")
  val unit : Rep[Int] = column[Int]("unit")
  override def * = (id, message, unit) <> (TestRecord.tupled, TestRecord.unapply)
  val id : Rep[Int] = column[Int]("ID", O.AutoInc, O.PrimaryKey)
}

// https://books.underscore.io/essential-slick/essential-slick-3.html
object ScalaSlickMysql extends App{
  def exec[T](action: DBIO[T]): T = Await.result(db.run(action), 4.seconds)

  // Create connection
  val configParameters: util.Map[String, String] = Map(
    "driver" -> "com.mysql.cj.jdbc.Driver",
    "url" -> "jdbc:mysql://localhost:3306/samur_test",
    "user" -> "",
    "password" -> "",
    "connectionPool" -> "disabled"
  ).asJava
  val conf: Config = ConfigFactory.parseMap(configParameters)
  val db = Database.forConfig("", config = conf)

  lazy val testTable = TableQuery[TestTable]
  val allRecordsQuery = testTable//filter...
  val allRecords: Future[Seq[TestRecord]] = db.run(allRecordsQuery.result)

  val magicNumber = Await.result(allRecords, Duration(5, TimeUnit.SECONDS))
  magicNumber.foreach(println)

}
