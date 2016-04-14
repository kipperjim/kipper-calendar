package kippercalendar

import org.joda.time.{DateTime, Interval}

object Calendar {

  val kipperCalendarContainerId = "kipperCalendarContainerId"

  def apply(initialDateTime: DateTime) =
    <div id={kipperCalendarContainerId}>
      {MonthCalendar(new Interval(new DateTime().withTimeAtStartOfDay(), new DateTime().withTimeAtStartOfDay().plusDays(1)))}
    </div>
}