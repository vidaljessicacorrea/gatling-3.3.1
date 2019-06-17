package chain

import java.util.concurrent.ThreadLocalRandom

import baseConfig.FeedersFiles
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef.http

object UserDependentDataChain extends ChainTest {

  private var userGuide = ""
  private var version = ""
  private var docs = ""

  private val GET_DOC_CURRENT = "/docs"

  private def getCustomURL(urlPath:String): ChainBuilder = {
    exec(http("GET " + GET_DOC_CURRENT+ urlPath)
      .get(GET_DOC_CURRENT + urlPath))
  }

  private val dependentData = feed(FeedersFiles.userGuideDependent)
      .exec(session => {

        userGuide = "/current" + session("USER_GUIDE").as[String]
        version = userGuide + session("VERSION").as[String]

        session("VERSION").validate[String].map { category =>
          val filters = FeedersFiles.filtersByVersion(category)
          val selectedFilter = filters(ThreadLocalRandom.current.nextInt(filters.length))
          docs = session("VERSION").as[String] + selectedFilter
        }
        session.set("DOCS", docs).set("USER_GUIDE", userGuide).set("VERSION", version)
      }
      )

  val getFilterURL = exec(dependentData)
      .exec(getCustomURL("${USER_GUIDE}"))
      .exec(getCustomURL("${VERSION}"))
      .exec(getCustomURL("${DOCS}"))





}
