package kippercalendar.acceptance.spec

import kippercalendar.acceptance.WebSpecification
import org.joda.time.DateTime

class MonthCalendarSpec extends WebSpecification {
  object `The next month button should` {
    def `display the next month`() {
      val page = in.driver.nav.gotoPage()

      page.assertDateShown(new DateTime())
      page.clickPreviousMonth
      page.assertDateShown(new DateTime().minusMonths(1))
    }
  }
}