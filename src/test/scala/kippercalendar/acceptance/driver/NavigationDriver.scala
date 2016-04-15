package kippercalendar.acceptance.driver

import im.mange.driveby.browser.Browser
import kippercalendar.acceptance.context.Context

case class NavigationDriver(context: Context, browser: Browser) {
  import browser._

  def gotoPage() = { CalendarDriver(context, goto(context.applicationBaseUrl))}
}