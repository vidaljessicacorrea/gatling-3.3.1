package simulations

import baseConfig.BaseSimulation
import scenario.ScenarioTest
import io.gatling.core.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class TestSearchSimulation4 extends BaseSimulation {


  // generate a closed workload injection profile
  // with levels of 10, 15, 20, 25 and 30 concurrent users
  // each level lasting 10 seconds
  // separated by linear ramps lasting 10 seconds
  setUp(
    ScenarioTest.searchComputers
      .inject(
        incrementConcurrentUsers(5) // Int
          .times(5)
          .eachLevelLasting(10 seconds)
          .separatedByRampsLasting(10 seconds)
          .startingFrom(10) // Int
      )
  ).protocols(httpConf)

}
