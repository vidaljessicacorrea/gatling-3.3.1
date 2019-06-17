package chain

import baseConfig.BaseConfig
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object TransformChain extends ChainTest {

  private def randomValue(number:Int) = new scala.util.Random().nextInt((number-1)+1)

  private val GET_DOC_CURRENT = "/docs/current/"

  private val REGEX_HREF = """<a class="reference internal" href="/docs/3.1/([a-z]+)">"""


  val getRandomLink = doIf(BaseConfig.baseUrl.contains("gatling")){
    exec(http("GET " + GET_DOC_CURRENT)
      .get(GET_DOC_CURRENT)
      .check(regex(REGEX_HREF).findAll.transform(list => BaseConfig.baseUrl + GET_DOC_CURRENT + list.get(randomValue(list.length-1)) ).saveAs("URL")))
      .exec(session => {
        fileLogger.info(session("URL").as[String])
        session
      })
  }

}
