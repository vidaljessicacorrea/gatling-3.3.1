package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._
import scala.language.postfixOps

class TestSearchSimulation1 extends BaseSimulation {


  setUp(
    ScenarioTest.navigateComputers.inject(atOnceUsers(totalUsers))
  ).protocols(httpConf)


}
