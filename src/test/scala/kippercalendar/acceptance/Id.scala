package kippercalendar.acceptance

import im.mange.common.AtomicIntCounter

object Id {
  private val port = new AtomicIntCounter(9501)
  def nextPort = port.next
}