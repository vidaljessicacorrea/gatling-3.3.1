package baseConfig

import io.gatling.core.Predef._
import io.gatling.http.Predef.http

class BaseSimulation extends Simulation{

  val baseUrl = BaseConfig.baseUrl
  val usersPerSec = BaseConfig.usersPerSec
  val totalUsers = BaseConfig.totalUsers
  val totalTimeMin = BaseConfig.totalTimeMin
  val pauseTimeMin = BaseConfig.pauseTimeMin
  val pauseTimeMax = BaseConfig.pauseTimeMax

  val httpConf = http
    .baseURL(baseUrl)
    .warmUp(baseUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val httpConfWithInferHtmlResources = http
    .baseURL(baseUrl)
    .warmUp(baseUrl)
    .inferHtmlResources()

  val httpConfWithWhiteAndBlackList = http
    .baseURL(baseUrl)
    .inferHtmlResources(WhiteList(".*\\.css.*"),BlackList(".*\\.js.*") )
    .disableWarmUp

}
