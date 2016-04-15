package kippercalendar.acceptance.context

import im.mange.driveby.Example
import im.mange.driveby.pool.Application


case class Context(application: Application, example: Example) {
  def applicationHomepageUrl = url("", example)

  def applicationUrl(path: String) = url(path, example)
  def applicationBaseUrl = application.baseUrl

  private def url(path: String, example: Example) = applicationBaseUrl + "/" + path + "?exampleId=" + example.id
}