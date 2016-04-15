package kippercalendar.acceptance

import im.mange.driveby.BrowserTypes
import kippercalendar.acceptance.application.{InProcessApplication, SpawnedApplicationController}

object BuildConfig {
  def applicationControllers(instanceCount: Int = 1, bonusInstances: Int = 0) = {
    InProcessApplication("In Process", Id.nextPort) :: 1.to((instanceCount + bonusInstances) -1)
      .map(n ⇒ SpawnedApplicationController("Spawned", Id.nextPort)).toList
  }

  def browserType = BrowserTypes.phantomjs
//  def browserType = BrowserTypes.chrome
}