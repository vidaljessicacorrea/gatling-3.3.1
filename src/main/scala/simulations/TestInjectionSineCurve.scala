package simulations
import _root_.scenario.ScenarioTest
import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import scala.concurrent.duration._


class TestInjectionSineCurve extends BaseSimulation {

  setUp(

    ScenarioTest.getHomePage.inject(
      heavisideUsers(200) over (1 minutes),
      heavisideUsers(200) over (1 minutes),
      heavisideUsers(200) over (1 minutes)
    )

  ).protocols(httpConf)
}
