name := "Test Jackson ( JSON de(serializer) ) on Scala case class"

version := "1.0"

scalaVersion := "2.10.4"

libraryDependencies += "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.13"


// Fork JVM when `run`-ing SBT
// http://stackoverflow.com/a/5265162/409976
fork in run := true