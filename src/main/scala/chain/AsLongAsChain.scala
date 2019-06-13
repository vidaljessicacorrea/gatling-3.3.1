package chain

import java.util.concurrent.atomic.AtomicInteger

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef.http

object AsLongAsChain extends ChainTest {

  val numIncremetal = new java.util.concurrent.atomic.AtomicInteger(0)

  private val goHomePage = exec(http("Go Home Page")
      .get(baseUrl))

  private def setSequenceNumber(sequenceNumber:AtomicInteger):ChainBuilder = exec(session => {
    session.set("SEQUENCE_NUMBER", "%d".format(sequenceNumber.getAndIncrement))
  })

  val getAsLongAs = asLongAs(session => numIncremetal.intValue() != 10){
        exec(setSequenceNumber(numIncremetal))
          .exec(session => {
            println(numIncremetal.intValue())
            session
          })
          .exec(goHomePage)
      }

}
