package chain

import baseConfig.FeedersFiles
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object NonSharedDataChain extends ChainTest {

  private val GET_DOC_CURRENT = "/docs/current/"

  private val getPage = exec(http("GET " + "${record}")
    .get(GET_DOC_CURRENT + "${record}"))

  val scnFlattenFeederIntoAtributtes = foreach(FeedersFiles.userGuideRecords, "record") {
      exec(flattenMapIntoAttributes("${record}"))
      .exec(getPage)
    }

}
