package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._

import scala.language.postfixOps

import scala.concurrent.duration._

class TestSearchSimulation2 extends BaseSimulation {


  setUp(
    ScenarioTest.searchComputers.inject(
      constantConcurrentUsers(10) during (10 seconds), // 1
      rampConcurrentUsers(10) to (20) during (10 seconds) // 2
    )
  ).protocols(httpConf)


}
