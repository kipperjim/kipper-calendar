name := "kipper-calendar"

organization := "kipperjim"

version := "1.0.0"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  "Maven Repo" at "http://repo1.maven.org/maven2/",
  "Sonatype Repo" at "https://oss.sonatype.org/content/groups/public/"
)

libraryDependencies ++= Seq(
  "net.liftweb" %% "lift-webkit" % "2.6.3" % "compile" withSources(),
  "org.scalaz" %% "scalaz-core" % "7.2.0" % "compile" withSources(),
  "ch.qos.logback" % "logback-classic" % "1.1.3",
  "im.mange" %% "little-server" % "0.0.8" %  "compile" withSources(),
  "im.mange" %% "driveby" % "0.3.28" % "test" withSources(),
  "org.scalatest" %% "scalatest" % "2.2.6" % "test" withSources()
)