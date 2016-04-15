package kippercalendar.acceptance

import im.mange.driveby.{BrowserTypes, DriveBy, DriveByConfig}

object WebSpecificationSuite {
  DriveByConfig.applicationControllers = BuildConfig.applicationControllers()
  DriveByConfig.browserInstances = 1
//  DriveByConfig.trackingVerbose = true

  BrowserTypes.chrome.driverBinary = "tools/chromedriver"
  BrowserTypes.phantomjs.driverBinary =
    System.getProperty("os.name") match {
      case "Mac OS X" ⇒ "tools/phantomjs-1.9.8-macosx/bin/phantomjs"
      case "Linux"    ⇒ "tools/phantomjs-1.9.8-linux-x86_64/bin/phantomjs"
      case _          ⇒ "phantomjs"
      case other      ⇒ throw new IllegalArgumentException(s"Unsupported operating system: $other")
    }

  DriveByConfig.browserType = BuildConfig.browserType

  DriveBy.start()
}