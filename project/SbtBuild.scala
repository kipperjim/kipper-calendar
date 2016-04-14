import sbt.Keys._
import sbt._

object BuildSettings {
  val app = "kipper-calendar"
  val dist = TaskKey[Unit]("dist")

  val kipperCalendarBuildSettings: Seq[Setting[_]] = Seq[Setting[_]](
    scalacOptions := Seq( "-feature", "-language:_", "-deprecation", "-unchecked"),
    logBuffered := true,
    logBuffered in Test := false,
    javaOptions ++= Seq("-Xmx1G", "-Xss4m", "-server")
  )
}

object SbtBuild extends Build {
  import BuildSettings._
  import sbt._

  lazy val kipperCalendar = Project("KipperCalendar", file(".")).settings(kipperCalendarBuildSettings: _*)
}