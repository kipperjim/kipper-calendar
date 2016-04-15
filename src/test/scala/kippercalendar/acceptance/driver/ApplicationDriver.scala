package kippercalendar.acceptance.driver

import im.mange.driveby.browser.Browser
import kippercalendar.acceptance.context.Context

case class ApplicationDriver(context: Context, browser: Browser) extends Navigable