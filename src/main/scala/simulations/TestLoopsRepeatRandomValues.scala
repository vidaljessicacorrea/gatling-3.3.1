package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import _root_.scenario.ScenarioTest

import scala.concurrent.duration._

class TestLoopsRepeatRandomValues extends BaseSimulation {

  setUp(

    ScenarioTest.getRepeatRandomValues.inject(constantUsersPerSec(usersPerSec) during(totalTimeMin minutes) )

  ).protocols(httpConf)
}
