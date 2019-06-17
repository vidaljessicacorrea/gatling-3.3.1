package chain

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.cookie.CookieSupport

object OptionValidationChain extends ChainTest {

  private val scn = exec(http("POST demo.guru99.com")
    .post("http://demo.guru99.com/V4/index.php")
  .formParam("uid","test")
    .formParam("password","test")
    .formParam("btnLogin","login"))

  private def getCookieValue(name: String, session: Session): String = {
    CookieSupport.getStoredCookies(session, "http://demo.guru99.com").find(_.getName == name) match {
      case Some(cookie) => cookie.getValue
      case _ => throw new Exception(s"""Cookie "$name" not found!""")
    }
  }

  val useOptionValidation = exec(scn)
    .exec(session => {
      val cookie = getCookieValue("PHPSESSID",session)
      consoleLogger.info("[COOKIE PHPSESSID: %s".format(cookie))
      session.set("PHPSESSID",cookie)
      session
    })
    .exec(doIf(!Option("${PHPSESSID}").get.isEmpty) {
      exec(http("GET /Agile_Project/Agi_V1/")
        .get("http://demo.guru99.com/Agile_Project/Agi_V1/"))
    })

}
