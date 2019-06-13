package simulations

import _root_.scenario.ScenarioTest
import baseConfig.BaseSimulation
import io.gatling.core.Predef._

import scala.concurrent.duration._

class TestInjectionSplit extends BaseSimulation {

  setUp(

    ScenarioTest.getHomePage.inject(splitUsers(totalUsers).into(rampUsers(10) over (20 seconds)).separatedBy(15 seconds))

  ).protocols(httpConf)
}
