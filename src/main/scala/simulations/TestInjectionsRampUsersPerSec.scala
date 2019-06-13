package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import _root_.scenario.ScenarioTest
import scala.concurrent.duration._

class TestInjectionsRampUsersPerSec extends BaseSimulation {

  setUp(

    ScenarioTest.getHomePage.inject(rampUsersPerSec(2) to (10) during(5 minutes))
  ).protocols(httpConf)

}
