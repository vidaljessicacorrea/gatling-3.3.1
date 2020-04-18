package scenario

import io.gatling.core.Predef.{scenario, _}
import _root_.chain.Computer
import scenarios.ScenarioName

object ScenarioTest {

  val searchComputers = scenario(ScenarioName.SEARCH_COMPUTERS)
    .exec(Computer.goHomePage)
    .exec(Computer.searchComputersByKeyword)

  val navigateComputers = scenario(ScenarioName.NAVIGATE_COMPUTERS)
  .exec(Computer.goHomePage)
    .exec(Computer.searchComputersByKeyword)
  .exec(Computer.getComputersByID)
  .exec(Computer.goHomePage)
  .exec(Computer.applyPagination)
  .exec(Computer.openNewComputer)
  .exec(Computer.saveComputerByID)
}



