package kippercalendar.acceptance.spec

import kippercalendar.acceptance.WebSpecification
import org.joda.time.DateTime

class MonthCalendarSpec extends WebSpecification {
  object `The next month button should` {
    def `update the calendar title`() {
      val page = in.driver.nav.gotoPage()

      page.clickNextMonth()

      page.assertMonthTitle(new DateTime().plusMonths(1))
    }
  }

  object `The previous month button should` {
    def `update the calendar title`() {
      val page = in.driver.nav.gotoPage()

      page.clickPreviousMonth()

      page.assertMonthTitle(new DateTime().minusMonths(1))
    }
  }
}