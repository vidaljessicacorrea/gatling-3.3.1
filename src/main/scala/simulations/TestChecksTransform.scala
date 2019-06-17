package simulations

import _root_.scenario.ScenarioTest
import baseConfig.BaseSimulation
import io.gatling.core.Predef._

import scala.concurrent.duration._

class TestChecksTransform extends BaseSimulation {

  setUp(

    ScenarioTest.getTransform.inject(atOnceUsers(totalUsers))

  ).protocols(httpConf)
}
