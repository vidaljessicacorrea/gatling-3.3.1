package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._
import scala.concurrent.duration._

class TestInjectionConstantUsersPerSecNormal extends BaseSimulation{
  setUp(
    ScenarioTest.getHomePage.inject(constantUsersPerSec(usersPerSec) during(totalTimeMin minutes))
  ).protocols(httpConf)


}
