package kippercalendar

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

object Clock {
  def monthFull(dateTime: DateTime) = dateTime.toString(DateTimeFormat.forPattern("MMMM"))
  def formatTime(dt: DateTime) = dt.toString(DateTimeFormat.forPattern("HH : mm"))
  def formatDate(dt: DateTime) = dt.toString(DateTimeFormat.forPattern("dd-MM-YYYY"))
  def dayOfTheWeek(dateTime: DateTime) = dateTime.toString(DateTimeFormat.forPattern("EEEE"))
  def dayOfTheMonth(dateTime: DateTime) = dateTime.toString(DateTimeFormat.forPattern("dd"))
  def dayOfTheWeekAndMonth(dateTime: DateTime) = dayOfTheWeek(dateTime) + " " + dayOfTheMonth(dateTime)

}
