package simulations

import _root_.scenario.ScenarioTest
import baseConfig.BaseSimulation
import io.gatling.core.Predef._

import scala.concurrent.duration._

class TestInjectionRampRandom extends BaseSimulation {

  setUp(

    ScenarioTest.getHomePage.inject(rampUsersPerSec(2) to (10) during(3 minutes) randomized)

  ).protocols(httpConf)
}
