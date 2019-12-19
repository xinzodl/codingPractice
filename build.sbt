name := "cosicas"

version := "0.1"

scalaVersion := "2.12.10"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.1.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"
libraryDependencies += "org.scalatestplus" %% "scalatestplus-scalacheck" % "3.1.0.0-RC2" % Test
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

//libraryDependencies += "com.novocode" %% "junit-interface" % "0.11" % "test"

//libraryDependencies += "junit" %% "junit" % "4.12"
libraryDependencies += "org.junit.platform" % "junit-platform-launcher" % "1.5.2" % Test
libraryDependencies += "org.junit.platform" % "junit-platform-engine" % "1.5.2" % Test
libraryDependencies += "org.junit.platform" % "junit-platform-runner" % "1.5.2" % Test


//testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")
