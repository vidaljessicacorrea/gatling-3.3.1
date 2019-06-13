package simulations

import _root_.scenario.ScenarioTest
import baseConfig.BaseSimulation
import io.gatling.core.Predef._

import scala.concurrent.duration._

class TestChecksTransformOption extends BaseSimulation{

  setUp(
    ScenarioTest.getTransformOption.inject(constantUsersPerSec(usersPerSec) during (totalTimeMin minutes))
  ).protocols(httpConf)


}
