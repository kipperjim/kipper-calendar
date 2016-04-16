package kippercalendar

import kippercalendar.Calendar._
import kippercalendar.Clock._
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmds._
import org.joda.time.Interval

import scala.xml.NodeSeq

object MonthCalendar {

  val previousMonthButtonId = "previousMonthButtonId"
  val nextMonthButtonId = "nextMonthButtonId"
  val monthTitleId = "monthTitleId"

  def apply(monthInterval: Interval): NodeSeq = {
    <h3>
      <span id={monthTitleId}>{title(monthInterval)}</span>
      {monthDayNavigationButtons(monthInterval, monthActive = true)}
    </h3> ++
    previousMonthButton(monthInterval) ++
    nextMonthButton(monthInterval)
  }

  def title(monthInterval: Interval) = monthInterval.getStart.getYear.toString + " " + monthFull(monthInterval.getStart)

  private def previousMonthButton(monthInterval: Interval) =
    SHtml.ajaxButton("< previous month", () ⇒ SetHtml(kipperCalendarContainerId, MonthCalendar(new Interval(monthInterval.getStart.minusMonths(1), monthInterval.getEnd.minusMonths(1)))), "id" → previousMonthButtonId, "class" → "col-lg-2 btn btn-primary")

  private def nextMonthButton(monthInterval: Interval) =
    SHtml.ajaxButton("next month >", () ⇒ SetHtml(kipperCalendarContainerId, MonthCalendar(new Interval(monthInterval.getStart.plusMonths(1), monthInterval.getEnd.plusMonths(1)))), "id" → nextMonthButtonId, "class" → "col-lg-2 col-lg-offset-8  btn btn-primary")

}
