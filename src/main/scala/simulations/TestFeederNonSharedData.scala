package simulations

import _root_.scenario.ScenarioTest
import baseConfig.BaseSimulation
import io.gatling.core.Predef._

import scala.concurrent.duration._

class TestFeederNonSharedData extends BaseSimulation {

  setUp(

    ScenarioTest.getNonSharedData.inject(constantUsersPerSec(usersPerSec) during (totalTimeMin.toInt minutes))

  ).protocols(httpConf)
}
