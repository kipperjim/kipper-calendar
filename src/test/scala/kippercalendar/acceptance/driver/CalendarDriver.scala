package kippercalendar.acceptance.driver

import im.mange.driveby.Id
import im.mange.driveby.browser.Browser
import im.mange.driveby.conditions.{AttributeContains, TextEquals}
import kippercalendar.{DayCalendar, MonthCalendar}
import kippercalendar.acceptance.context.Context
import org.joda.time.{Interval, DateTime}

case class CalendarDriver(context: Context, browser: Browser) extends Navigable {
  import kippercalendar.MonthCalendar._
  import kippercalendar.DayCalendar._
  import kippercalendar.Calendar._

  def clickPreviousMonth = click(previousMonthButtonId)
  def clickNextMonth = click(nextMonthButtonId)

  def assertMonthTitle(date: DateTime) = browser.assert(TextEquals(Id(monthTitleId), MonthCalendar.title(new Interval(date, date.plusMonths(1)))))
  def assertDayTitle(date: DateTime) = browser.assert(TextEquals(Id(dayTitleId), DayCalendar.title(new Interval(date, date.plusMonths(1)))))
  def assertMonthActive = browser.assert(AttributeContains(Id(monthViewButtonId), "class", "active"))
  def assertDayActive = browser.assert(AttributeContains(Id(dayViewButtonId), "class", "active"))
  def assertPreviousMonthButtonDisplayed = browser.assert(TextEquals(Id(previousMonthButtonId), "< previous month"))
  def assertNextMonthButtonDisplayed = browser.assert(TextEquals(Id(nextMonthButtonId), "next month >"))
}