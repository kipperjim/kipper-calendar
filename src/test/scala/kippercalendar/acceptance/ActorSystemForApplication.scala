package kippercalendar.acceptance

import akka.actor.ActorSystem
import com.typesafe.config.ConfigFactory
import net.liftweb.common.Loggable


case class ActorSystemForApplication(testSystemPort: Int, targetSystemPort: Int) extends Loggable {
  private val configuration = ConfigFactory.load(ConfigFactory.parseString("""
    test {
      akka {
        actor {
          provider = "akka.remote.RemoteActorRefProvider"
        }

        remote {
          log-remote-lifecycle-events = off
        }

        remote.netty.tcp.port = %d
        log-dead-letters = 0
        log-dead-letters-during-shutdown = off
      }
    }
                                                                           """.format(testSystemPort)))

  private val system = ActorSystem("KipperCalendarTest", configuration.getConfig("test"))
  val remoteBackGardenActor = system.actorSelection("akka.tcp://KipperCalendarInternalSystem@" + BuildConfig.hostAddress + ":" + targetSystemPort + "/user/backgarden")

  def shutdown() { system.shutdown() }
}