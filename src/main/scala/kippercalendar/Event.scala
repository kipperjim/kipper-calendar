package kippercalendar

import org.joda.time.Interval

case class Event(interval: Interval, label: String) {
  val start = interval.getStart
  val end = interval.getEnd
}
