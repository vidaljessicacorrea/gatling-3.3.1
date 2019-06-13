package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import _root_.scenario.ScenarioTest
import scala.concurrent.duration._

class TestFeederExtractMoreThanOneValue extends BaseSimulation{

  setUp(

    ScenarioTest.getFeederWithMoreThanOneValue.inject(constantUsersPerSec(usersPerSec) during (totalTimeMin.toInt minutes))

  ).protocols(httpConf)



}
