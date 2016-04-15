package kippercalendar.acceptance

import im.mange.driveby.browser.Browser
import kippercalendar.acceptance.context.Context
import kippercalendar.acceptance.driver.ApplicationDriver

case class In(context: Context, browser: Browser) {
  val id = context.example.id

  val driver: ApplicationDriver = ApplicationDriver(context, browser.goto(context.applicationHomepageUrl))
}