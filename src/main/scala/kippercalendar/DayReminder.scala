package kippercalendar

import kippercalendar.Clock.monthFull
import org.joda.time.DateTime

case class DayReminder(date: DateTime, label: String) {
  val year = date.year().get()
  val month = monthFull(date)
}