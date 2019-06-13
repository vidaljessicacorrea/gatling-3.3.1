package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._
import scala.concurrent.duration._

class TestInjectionsNothingFor extends BaseSimulation{

  setUp(
    ScenarioTest.getHomePage.inject(atOnceUsers(100), nothingFor(10 seconds), atOnceUsers(50))
  ).protocols(httpConf)


}
