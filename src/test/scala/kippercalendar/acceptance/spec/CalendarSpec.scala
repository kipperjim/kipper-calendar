package kippercalendar.acceptance.spec

import kippercalendar.acceptance.WebSpecification
import org.joda.time.DateTime

class CalendarSpec extends WebSpecification {
  object `The initial render should` {
    def `display the month calendar on the current month`() {
      val page = in.driver.nav.gotoPage()

      page.assertMonthActive
      page.assertMonthTitle(new DateTime())
      page.assertNextMonthButtonDisplayed
      page.assertPreviousMonthButtonDisplayed
    }
  }
}