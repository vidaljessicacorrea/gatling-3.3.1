package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class TestSearchSimulation5 extends BaseSimulation {


  setUp(
    ScenarioTest.searchComputers
      .inject(
        heavisideUsers(40) during  (1 minutes),
        heavisideUsers(40) during (1 minutes),
        heavisideUsers(40) during (1 minutes)
      )
  ).protocols(httpConf)

}
