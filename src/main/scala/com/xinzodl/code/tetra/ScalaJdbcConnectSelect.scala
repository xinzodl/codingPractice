package com.xinzodl.code.tetra

import java.sql.{Connection,DriverManager}

object ScalaJdbcConnectSelect extends App {
  def insert = "INSERT INTO test (message, unit) VALUES ('a la uco del rayo',8002), ('2.3 en retiro',8534);"
  def select = "SELECT message, unit FROM test"

  // connect to the database named "samur_test" on port 3306 of localhost
  val url = "jdbc:mysql://localhost:3306/samur_test"
  val driver = "com.mysql.cj.jdbc.Driver"
  val username = ""
  val password = ""
  var connection:Connection = _
  try {
    Class.forName(driver)
    connection = DriverManager.getConnection(url, username, password)
    val statement = connection.createStatement
//    statement.execute(insert)
    val rs = statement.executeQuery(select)
    while (rs.next) {
      val message = rs.getString("message")
      val unit = rs.getString("unit")
      println(s"message = $message, unit = $unit")
    }
  } catch {
    case e: Exception => e.printStackTrace
  }
  connection.close
}