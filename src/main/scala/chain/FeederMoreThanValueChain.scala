package chain

import baseConfig.FeedersFiles
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object FeederMoreThanValueChain extends ChainTest {

  private val DOC_CURRENT = "/docs/current"

  val searchWithFeeder = feed(FeedersFiles.userGuide,2)
    .exec(http( "${USER_GUIDE1}")
      .get(DOC_CURRENT +"${USER_GUIDE1}"))
    .exec(http("${USER_GUIDE2}")
      .get(DOC_CURRENT +"${USER_GUIDE2}"))

}
