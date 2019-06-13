package chain

import baseConfig.BaseConfig
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object RandomSwitchChain extends ChainTest {

  private val documentation_2_2 = "/docs/2.2"
  private val documentation_2_3 = "/docs/2.3"
  private val documentation_3_0 = "/docs/3.0"
  private val documentation_3_1 = "/docs/3.1"

  private val getDocumentation22 = exec(http("GET /docs/2.2")
    .get(BaseConfig.baseUrl + documentation_2_2))

  private val getDocumentation23 = exec(http("GET /docs/2.3")
    .get(BaseConfig.baseUrl + documentation_2_3))

  private val getDocumentation30 = exec(http("GET /docs/3.0")
    .get(BaseConfig.baseUrl + documentation_3_0))

  private val getDocumentation31 = exec(http("GET /docs/3.1")
    .get(BaseConfig.baseUrl + documentation_3_1))

  val getRandomSwitch = randomSwitch(
        10.0 -> exec(getDocumentation22),
        15.0 -> exec(getDocumentation23),
        25.0 -> exec(getDocumentation30),
        50.0 -> exec(getDocumentation31)
      )
}
