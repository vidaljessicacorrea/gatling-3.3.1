package chain

import baseConfig.BaseConfig
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object TransformChain extends ChainTest {

  private def randomValue(number:Int) = new scala.util.Random().nextInt((number-1)+1)

  val getRandomLink = exec(http("GET")
      .get(BaseConfig.baseUrl)
      .check(regex("""href="/sodimac-cl/(.*)" rel""").findAll.transform(list => BaseConfig.baseUrl + list.get(randomValue(list.length-1)) ).saveAs("URL")))
    .exec(session => {
      consoleLogger.info(session("URL").as[String])
      session
    })

}
