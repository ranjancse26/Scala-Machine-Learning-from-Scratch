name := "scalaml-algo"

version := "0.5"

scalaVersion := "2.12.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % "test"

assemblyJarName in assembly := name.value + ".jar"
