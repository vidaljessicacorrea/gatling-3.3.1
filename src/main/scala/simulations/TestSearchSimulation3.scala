package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class TestSearchSimulation3 extends BaseSimulation {


  // generate an open workload injection profile
  // with levels of 10, 15, 20, 25 and 30 arriving users per second
  // each level lasting 10 seconds
  // separated by linear ramps lasting 10 seconds
  setUp(
    ScenarioTest.searchComputers
      .inject(
      incrementUsersPerSec(5) // Double
        .times(5)
        .eachLevelLasting(10 seconds)
        .separatedByRampsLasting(10 seconds)
        .startingFrom(10) // Double
    )
  ).protocols(httpConf)

}
