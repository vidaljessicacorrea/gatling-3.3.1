package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import _root_.scenario.ScenarioTest
import scala.concurrent.duration._

class TestInjectionThroughputBased extends BaseSimulation{

  setUp(

    ScenarioTest.getHomePage.inject(constantUsersPerSec(400) during( 60 seconds)).throttle(reachRps(20) in (20 seconds),jumpToRps(10))

  ).protocols(httpConf)

}
