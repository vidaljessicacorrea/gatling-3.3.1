package chain

import baseConfig.{BaseLogger}
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object ExtraInfoChain extends ChainTest {

  val extraInfo = exec(http("GET " + baseUrl)
      .get(baseUrl)
      .extraInfoExtractor { extraInfo => List(BaseLogger.loggerInfo(extraInfo)) })
}
