package com.xinzodl.code.tetra

import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClientBuilder
import io.lemonlabs.uri.Url

object Post extends App{

  val uri = ""
  val uri2 = Url.parse(uri).toString()
  println(uri2)
  val post = new HttpPost(uri2)
  val client = HttpClientBuilder.create.build
  val response = client.execute(post)



}
