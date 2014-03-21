name := "CheckYou"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)     

play.Project.playJavaSettings
