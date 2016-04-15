package kippercalendar.acceptance.application

import im.mange.driveby.pool.{Application, ApplicationController}
import im.mange.little.LittleServer

import scala.io.Source

case class InProcessApplication(name: String, port: Int) extends ApplicationController {
  val application = Application(name, port)

  private val server = new LittleServer(port, autoStart = false, webAppPath = "src/test/webapp")

  def start() { server.start() }

  def stop() { }

  def hasStarted = {
    true
//    Source.fromURL(application.baseUrl + "/given/system/hasStarted").getLines().toList.headOption.contains("OK")
  }
}