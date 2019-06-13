package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._

import scala.concurrent.duration._

class TestInjectionHeavisideUsers extends BaseSimulation{


  setUp(

    ScenarioTest.getHomePage.inject(
      heavisideUsers(totalUsers) over (totalTimeMin minutes)
    )

  ).protocols(httpConf)


}
