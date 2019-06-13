package chain

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object TransformOptionChain extends ChainTest {

  val useTransformOption = exec(http("GET Home Page")
      .get("/").check(regex("""<a href="javascript:;" title="(.*)" data-toggle="modal" data-target="#myModal"""")
      .transformOption(extract => extract match {
        case None => Some("""title=""""")
        case Some(x) => Some("""title="""" + x + """"""")
      })
      .saveAs("VALUE_TITLE")))
    .exec(session => {
      consoleLogger.info(session.toString())
      session
    }
    )
}
