package baseConfig

import io.gatling.core.Predef._
import io.gatling.core.feeder._

object FeedersFiles {

  val keywords = csv(FeederNames.KEYWORDS).circular
  val companies = csv(FeederNames.COMPANIES).random
}
