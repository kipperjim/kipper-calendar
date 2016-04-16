package kippercalendar

import kippercalendar.Calendar._
import kippercalendar.Clock._
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmds.SetHtml
import org.joda.time.Interval

import scala.xml.NodeSeq

object DayCalendar {

  val previousDayButtonId = "previousDayButtonId"
  val nextDayButtonId = "nextDayButtonId"
  val dayTitleId = "dayTitleId"

  def apply(day: Interval): NodeSeq =
    <h3>
      <span id={dayTitleId}>{title(day)}</span>
      {monthDayNavigationButtons(day, monthActive = false)}
    </h3> ++
      previousDayButton(day) ++
      nextDayButton(day)

  def title(day: Interval) = dayOfTheWeekAndMonth(day.getStart) + " " + monthFull(day.getStart) + " " + day.getStart.getYear

  private def previousDayButton(monthInterval: Interval) =
    SHtml.ajaxButton("< previous day", () ⇒ SetHtml(kipperCalendarContainerId, DayCalendar(new Interval(monthInterval.getStart.minusDays(1), monthInterval.getEnd.minusDays(1)))), "id" → previousDayButtonId, "class" → "col-lg-2 btn btn-primary")

  private def nextDayButton(monthInterval: Interval) =
    SHtml.ajaxButton("next day >", () ⇒ SetHtml(kipperCalendarContainerId, DayCalendar(new Interval(monthInterval.getStart.plusDays(1), monthInterval.getEnd.plusDays(1)))), "id" → nextDayButtonId, "class" → "col-lg-2 col-lg-offset-8  btn btn-primary")
}