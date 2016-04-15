package kippercalendar.acceptance.application

import im.mange.common.ProcessRunner
import im.mange.driveby.pool.{Application, ApplicationController}


case class SpawnedApplicationController(name: String, port: Int) extends ApplicationController {
  val application = Application(name, port) // BuildConfig.hostName

  def start() { new ProcessRunner("Start " + application, "target/specs-parallel/startScript.sh " + port).start() }

  def stop() {}

  def hasStarted = true
}