package chain

import baseConfig.BaseConfig
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object TransformOptionChain extends ChainTest {

  private val GET_DOC_CURRENT = "/docs/current/"

  private val REGEX_TITLE = """">([a-zA-Z ]+)</a></li>"""

  val useTransformOption = doIf(BaseConfig.baseUrl.contains("gatling")){
    exec(http("GET Home Page")
      .get(GET_DOC_CURRENT).check(regex(REGEX_TITLE)
      .transformOption(extract => extract match {
        case None => Some("""title=""""")
        case Some(x) => Some("""title="""" + x + """"""")
      })
      .saveAs("VALUE_TITLE")))
      .exec(session => {
        fileLogger.info(session("VALUE_TITLE").as[String])
        session
      }
      )
  }

}
