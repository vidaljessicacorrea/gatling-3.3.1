package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import _root_.scenario.ScenarioTest
import scala.concurrent.duration._

class TestInjectionRandomPause extends BaseSimulation{

  setUp(

    ScenarioTest.getRandomPause(pauseTimeMin,pauseTimeMax).inject(constantUsersPerSec(usersPerSec) during (totalTimeMin minutes))

  ).protocols(httpConf)

}
