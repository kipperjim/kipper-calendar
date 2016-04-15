package kippercalendar

import net.liftweb.common.{Full, Loggable}
import net.liftweb.http._
import net.liftweb.http.rest.RestHelper
import net.liftweb.json.JsonAST.{JArray, JNothing}
import net.liftweb.util.Helpers._

import scala.language.postfixOps
import scalaz._

object RestAPI extends RestHelper with Loggable {
  serve {
    case r@"given" :: "system" :: "hasStarted" :: _ Get _ ⇒
      Full(PlainTextResponse("OK"))
  }
}