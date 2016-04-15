package bootstrap.liftweb

import kippercalendar.view.View
import net.liftweb.common.{Full, Loggable}
import net.liftweb.http._
import net.liftweb.sitemap.Loc.Hidden
import net.liftweb.sitemap.{Menu, SiteMap}
import net.liftweb.util.NamedPF

class Boot extends Loggable {
  def boot() { doOrDie(unsafeBoot) }

  private def doOrDie(f: () ⇒ Unit) { try { f() } catch { case t: Throwable ⇒ logger.error(t.getMessage); t.printStackTrace(); System.exit(1) } }

  private def unsafeBoot() {
    logger.info(">>> Booting")

    LiftRules.addToPackages("kippercalendar")
    LiftRules.logServiceRequestTiming = false

    setupSitemap()
    setup404Handler()
    setupViewDispatch()

    logger.info(">>> Lift has Booted.")
  }

  private def setupSitemap() {
    LiftRules.setSiteMap(SiteMap(Menu(S ? "Menu") / "menu" submenus ((Menu(S ? "Index") / "index" >> Hidden) :: Nil)))
  }

  private def setupViewDispatch() {
    LiftRules.viewDispatch.append {
      case List(page) if page == "index" ⇒                                Left(() ⇒ Full(View()))
    }
  }

  private def setup404Handler() {
    LiftRules.uriNotFound.prepend(NamedPF("404handler") {
      case (req, failure) ⇒ NotFoundAsTemplate(ParsePath(List("404"), "html", absolute = false, endSlash = false))
    })
  }
}