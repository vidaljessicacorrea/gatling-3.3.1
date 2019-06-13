package simulations

import _root_.scenario.ScenarioTest
import baseConfig.BaseSimulation
import io.gatling.core.Predef._

import scala.concurrent.duration._

class TestInjectionRampNotRandom extends BaseSimulation {

  setUp(

    ScenarioTest.getHomePage.inject(rampUsersPerSec(2) to (10) during(3 minutes))

  ).protocols(httpConf)
}
