package baseConfig

import io.gatling.core.Predef._
import io.gatling.http.Predef.http

class BaseSimulation extends Simulation{

  val baseUrl = LoadConfiguration.baseUrl
  val usersPerSec = LoadConfiguration.usersPerSec
  val totalUsers = LoadConfiguration.totalUsers
  val totalTimeMin = LoadConfiguration.totalTimeMin
  val pauseTimeMin = LoadConfiguration.pauseTime

  val httpConf = http
    .baseUrl(baseUrl)
    .warmUp(baseUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

}
