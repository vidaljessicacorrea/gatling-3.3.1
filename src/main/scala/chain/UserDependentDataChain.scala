package chain

import java.util.concurrent.ThreadLocalRandom

import baseConfig.FeedersFiles
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef.http

object UserDependentDataChain {

  private var userGuide = ""
  private var version = ""
  private var docs = ""

  private def getCustomURL(urlPath:String): ChainBuilder = {
    exec(http("GET " + urlPath)
      .get(urlPath))
  }

  private val dependentData = feed(FeedersFiles.userGuideDependent)
      .exec(session => {
        userGuide = System.getProperty("gatling.URL") + session("USER_GUIDE").as[String]
        version = System.getProperty("gatling.URL") + session("VERSION").as[String]
        session("VERSION").validate[String].map { category =>
          val filters = FeedersFiles.filtersByVersion(category)
          val selectedFilter = filters(ThreadLocalRandom.current.nextInt(filters.length))
          docs = System.getProperty("gatling.URL") + session("VERSION").as[String] + selectedFilter
        }
        session.set("DOCS", docs).set("USER_GUIDE", userGuide).set("VERSION", version)
      }
      )

  val getFilterURL = exec(dependentData)
      .exec(getCustomURL("${USER_GUIDE}"))
      .exec(getCustomURL("${VERSION}"))
      .exec(getCustomURL("${DOCS}"))





}
