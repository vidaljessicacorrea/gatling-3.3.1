package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._
import scala.concurrent.duration._

class TestInjectionConstantUsersPerSecRandom extends BaseSimulation{
  setUp(
    ScenarioTest.getHomePage.inject(constantUsersPerSec(usersPerSec) during(totalTimeMin minutes) randomized)
  ).protocols(httpConf)

}
