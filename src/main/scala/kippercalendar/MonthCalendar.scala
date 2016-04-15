package kippercalendar

import kippercalendar.Calendar._
import kippercalendar.Clock._
import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmds
import net.liftweb.http.js.JsCmds._
import org.joda.time.{DateTime, Interval}

import scala.xml.NodeSeq

object MonthCalendar {

  def apply(monthInterval: Interval): NodeSeq = {
    <h3>
      {monthInterval.getStart.getYear.toString + " " + monthFull(monthInterval.getStart)}
      <div class="btn-group pull-right">
        {SHtml.ajaxButton("Day", () ⇒ SetHtml(kipperCalendarContainerId, DayCalendar(new Interval(monthInterval.getStart.withDayOfMonth(new DateTime().getDayOfMonth), monthInterval.getStart.withDayOfMonth(new DateTime().getDayOfMonth).plusDays(1)))), "class" → "btn btn-default")}
        {SHtml.ajaxButton("Month", () ⇒ JsCmds.Noop, "class" → "btn btn-default active")}
      </div>
    </h3> ++
    previousMonthButton(monthInterval) ++
    nextMonthButton(monthInterval)
  }

  private def previousMonthButton(monthInterval: Interval) =
    SHtml.ajaxButton("< previous month", () ⇒ SetHtml(kipperCalendarContainerId, MonthCalendar(new Interval(monthInterval.getStart.minusMonths(1), monthInterval.getEnd.minusMonths(1)))), "class" → "col-lg-2 btn btn-primary")

  private def nextMonthButton(monthInterval: Interval) =
    SHtml.ajaxButton("next month >", () ⇒ SetHtml(kipperCalendarContainerId, MonthCalendar(new Interval(monthInterval.getStart.plusMonths(1), monthInterval.getEnd.plusMonths(1)))), "class" → "col-lg-2 col-lg-offset-8  btn btn-primary")

}
