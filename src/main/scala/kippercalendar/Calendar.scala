package kippercalendar

import net.liftweb.http.SHtml
import net.liftweb.http.js.JsCmds
import net.liftweb.http.js.JsCmds.SetHtml
import org.joda.time.{DateTime, Interval}

object Calendar {

  val kipperCalendarContainerId = "kipperCalendarContainerId"

  def apply(initialDateTime: DateTime) =
    <form class="lift:form.ajax">
      <div id={kipperCalendarContainerId}>
        {MonthCalendar(new Interval(new DateTime().withTimeAtStartOfDay(), new DateTime().withTimeAtStartOfDay().plusDays(1)))}
      </div>
    </form>

  def monthDayNavigationButtons(intervalDisplayed: Interval, monthActive: Boolean = true) =
    <div class="btn-group pull-right">
      {SHtml.ajaxButton("Day", () ⇒ SetHtml(kipperCalendarContainerId, DayCalendar(new Interval(intervalDisplayed.getStart.withDayOfMonth(new DateTime().getDayOfMonth), intervalDisplayed.getStart.withDayOfMonth(new DateTime().getDayOfMonth).plusDays(1)))), "class" → {if (!monthActive) "btn btn-default active" else "btn btn-default"})}
      {SHtml.ajaxButton("Month", () ⇒ SetHtml(kipperCalendarContainerId, MonthCalendar(new Interval(intervalDisplayed.getStart.withDayOfMonth(1), intervalDisplayed.getStart.withDayOfMonth(1).plusMonths(1).minusDays(1)))), "class" → {if (monthActive) "btn btn-default active" else "btn btn-default"})}
    </div>
}