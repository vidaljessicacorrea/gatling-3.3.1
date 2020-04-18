package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._
import io.gatling.core.controller.inject.open.{OpenInjectionStep}

import scala.collection.mutable.ListBuffer
import scala.concurrent.duration._
import scala.language.postfixOps

class TestSearchSimulation6 extends BaseSimulation {


  var steps = ListBuffer[OpenInjectionStep]()

  val duration = (2 minutes);
  val stages = 5;
  val ratePerStage = 0.1;

  for (s <- 1 to stages) {
    val rate = s * ratePerStage
    steps += constantUsersPerSec(rate) during (duration)
  }

  setUp(
    ScenarioTest.searchComputers
      .inject(steps)
  ).protocols(httpConf)

}
