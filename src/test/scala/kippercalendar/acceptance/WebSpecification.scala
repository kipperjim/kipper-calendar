package kippercalendar.acceptance

import im.mange.driveby.scalatest.{BrowsersAndApplications, DriveBySpecification}
import kippercalendar.acceptance.context.Context

trait WebSpecification extends DriveBySpecification with BrowsersAndApplications {
  WebSpecificationSuite

  private def context = Context(application, example)

  protected def in = In(context, browser)
}