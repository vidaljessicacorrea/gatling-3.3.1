package chain

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object RepeatRandomValuesChain extends ChainTest {

  private val randomValue = new scala.util.Random().nextInt((10-1)+1)

  val getRandom = repeat(randomValue)(
        exec(http(baseUrl)
          .get(baseUrl))
      )
}
