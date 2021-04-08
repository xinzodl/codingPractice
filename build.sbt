name := "cosicas"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"

libraryDependencies += "joda-time" % "joda-time" % "2.10.10"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.13"

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.23"

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.1"
libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.4"

libraryDependencies += "io.lemonlabs" %% "scala-uri" % "3.2.0"

libraryDependencies += "org.scalatestplus" %% "scalatestplus-scalacheck" % "3.1.0.0-RC2" % Test
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

libraryDependencies += "org.junit.platform" % "junit-platform-launcher" % "1.5.2" % Test
libraryDependencies += "org.junit.platform" % "junit-platform-engine" % "1.5.2" % Test
libraryDependencies += "org.junit.platform" % "junit-platform-runner" % "1.5.2" % Test
