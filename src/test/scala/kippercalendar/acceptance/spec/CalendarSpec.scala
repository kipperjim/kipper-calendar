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

  object `The day calendar button should` {
    def `display the day calendar from the month calendar`() {
      val page = in.driver.nav.gotoPage()

      page.clickDisplayDayCalendar()
      page.assertDayTitle(new DateTime())
      page.assertNextDayButtonDisplayed
      page.assertPreviousDayButtonDisplayed
    }
  }

  object `The month calendar button should` {
    def `display the month calendar from the day calendar`() {
      val page = in.driver.nav.gotoPage()

      page.clickDisplayDayCalendar()

      page.clickDisplayMonthCalendar()
      page.assertMonthTitle(new DateTime())
      page.assertNextMonthButtonDisplayed
      page.assertPreviousMonthButtonDisplayed
    }
  }
}