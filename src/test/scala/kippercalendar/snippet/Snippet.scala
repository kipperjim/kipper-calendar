package kippercalendar.snippet

import kippercalendar.Calendar
import org.joda.time.DateTime

case class Snippet() {
  def render = Calendar(new DateTime())
}
