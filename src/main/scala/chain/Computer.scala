package chain

import baseConfig.{BaseChains, FeedersFiles}
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Computer extends BaseChains{

  val goHomePage = exec(http("/")
      .get("/")
      .check(status.is(200)))
    .pause(shortPause)

  val searchComputersByKeyword = feed(FeedersFiles.keywords)
    .exec(http("/computers?f=" + "${KEYWORD_NAME}")
    .get("/computers?f=" + "${KEYWORD_NAME}")
    .check(status.is(200)))
    .pause(shortPause)

  val applyPagination = repeat(5, "n") {
    exec(http("/computers?p=" + "${n}")
      .get("/computers?" + "p=" + "${n}")
      .check(status.is(200)))
    .pause(longPause)
  }

  val getComputersByID = exec(http("/computers/" + 1)
      .get("/computers/" + 1)
      .check(status.is(200)))
    .pause(shortPause)

  val saveComputerByID = feed(FeedersFiles.companies)
    .exec(http("/computers")
    .post("/computers")
      .formParam("name","Beautiful Computer")
    .formParam("introduced", getDate)
    .formParam("discontinued","")
    .formParam("company","${COMPANY_ID}")
    .check(status.is(200)))
    .pause(shortPause)

  val openNewComputer = exec(http("/computers/new")
    .get("/computers/new")
    .check(status.is(200)))
    .pause(shortPause)


}
