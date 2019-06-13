package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._

import scala.concurrent.duration._

class TestLoopsAsLongAs extends BaseSimulation{


  setUp(

    ScenarioTest.getAsLongAs.inject(constantUsersPerSec(usersPerSec) during(totalTimeMin minutes) )

  ).protocols(httpConf)


}
