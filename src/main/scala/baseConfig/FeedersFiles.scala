package baseConfig

import io.gatling.core.Predef._
import io.gatling.core.feeder._

object FeedersFiles {

  val userGuide = csv(FeederNames.USER_GUIDE).circular

  val userGuideDependent = csv(FeederNames.USER_GUIDE_DEPENDENT).circular

  val docs = csv(FeederNames.DOCS).circular

  val recordsByVersion: Map[String, IndexedSeq[Record[String]]] =
    csv(FeederNames.DOCS).records.groupBy { record => record("VERSION") }

  val filtersByVersion: Map[String, IndexedSeq[String]] =
    recordsByVersion.mapValues { records => records.map { record => record("DOCS") } }

  val userGuideRecords = csv(FeederNames.USER_GUIDE).records
}
