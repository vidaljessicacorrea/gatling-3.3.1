package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._

import scala.concurrent.duration._

class TestChecksOptionValidation extends BaseSimulation{


  setUp(
    ScenarioTest.getOptionValidation.inject(constantUsersPerSec(usersPerSec) during (totalTimeMin.toInt minutes))
  ).protocols(httpConf)


}
