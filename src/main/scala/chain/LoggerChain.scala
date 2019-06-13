package chain

import io.gatling.core.Predef._
import baseConfig.BaseConfig
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object LoggerChain extends ChainTest {

  private val getLogger : ChainBuilder = {
    exec(session =>{
      val url = "********************************"+session("DATE").as[String]+"**************************"
      consoleLogger.debug(url)
      session
    }
    )
  }

  private val getHeader_save =
    exec(http("GetHeader")
      .get(BaseConfig.baseUrl)
      .check(header("Date").saveAs("DATE")))


  val getHeader = scenario("GetHeader")
    .exec(getHeader_save)
    .exec(getLogger)

}
