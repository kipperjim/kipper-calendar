package kippercalendar.acceptance.spec

import kippercalendar.acceptance.WebSpecification
import org.joda.time.DateTime

class DayCalendarSpec extends WebSpecification {
  object `The next day button should` {
    def `update the calendar title`() {
      val page = in.driver.nav.gotoPage()

      page.clickDisplayDayCalendar()
      page.clickNextDay()

      page.assertDayTitle(new DateTime().plusDays(1))
    }
  }

  object `The previous day button should` {
    def `update the calendar title`() {
      val page = in.driver.nav.gotoPage()

      page.clickDisplayDayCalendar()
      page.clickPreviousDay()

      page.assertDayTitle(new DateTime().minusDays(1))
    }
  }
}