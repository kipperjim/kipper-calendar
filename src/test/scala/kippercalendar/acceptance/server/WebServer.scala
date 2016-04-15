package kippercalendar.acceptance.server

import im.mange.little.LittleServer

class WebServer(port: Int) {
  new LittleServer(port, webAppPath = "src/test/webapp")
  println("### Started web server on port %d...".format(port))
}