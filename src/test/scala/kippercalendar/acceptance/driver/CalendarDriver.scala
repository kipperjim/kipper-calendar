package kippercalendar.acceptance.driver

import im.mange.driveby.Id
import im.mange.driveby.browser.Browser
import im.mange.driveby.conditions.TextEquals
import kippercalendar.MonthCalendar
import kippercalendar.acceptance.context.Context
import org.joda.time.{Interval, DateTime}

case class CalendarDriver(context: Context, browser: Browser) extends Navigable {
  import kippercalendar.MonthCalendar._

  def clickPreviousMonth = click(previousMonthButtonId)
//  def typeEmailAddress(emailAddress: String) = typeIn(emailAddressField, emailAddress)
//  def typePassword(password: String) = typeIn(passwordField, password)
//  def clickLostPassword = browser.click(Id(lostPasswordLink))
//
  def assertDateShown(date: DateTime) = browser.assert(TextEquals(Id(dateDisplayedId), MonthCalendar.title(new Interval(date, date.plusMonths(1)))))
}