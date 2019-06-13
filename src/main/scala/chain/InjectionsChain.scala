package chain

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object InjectionsChain extends ChainTest {

  val goHomePage = exec(http("Go Home Page")
    .get(baseUrl))

  def randomPause(min:Int,max:Int) = pause(min, max)
    .exec(goHomePage)
}
