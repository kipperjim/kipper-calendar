package kippercalendar.acceptance.server

import im.mange.little.LittleServer
import net.liftweb.common.Loggable

class WebServer(port: Int) extends Loggable {
  new LittleServer(port, webAppPath = "src/test/webapp")
  println("### Started web server on port %d...".format(port))
  logger.info("### Started web server on port %d...".format(port))
}