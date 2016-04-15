package kippercalendar.acceptance.driver

import im.mange.driveby.Id
import im.mange.driveby.browser.Browser
import im.mange.driveby.conditions.{TextContains, TextEquals, TitleEquals}
import kippercalendar.acceptance.context.Context


trait Navigable {
  def context: Context
  def browser: Browser
  def nav = NavigationDriver(context, browser)

  def typeIn(id: String, value: String) {
    browser.clear(Id(id))
    browser.enter(Id(id), value)
  }

  def click(id: String) {
    browser.enter(Id(id), "")
    browser.click(Id(id))
  }
}