package chain

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import baseConfig.{BaseConfig, BaseLogger}
import io.gatling.http.cookie.CookieSupport

object OptionValidationChain extends ChainTest {

  private val scn = exec(http("GET Go Home")
      .get(BaseConfig.baseUrl))

  private  val getLogin = exec(http("get login")
      .get("https://secure.sodimac.cl/sodimac-cl/myaccount/login")
      .check(status))

  private val paramQuery = "/sodimac-cl/myaccount/includes/personalLogin.jsp.loginFormOld"

  private val formParam = Map(
    "_dyncharset" -> "iso-8859-1",
    "/atg/userprofiling/ProfileFormHandler.value.login" -> "selenium@yopmail.com",
    "_D:/atg/userprofiling/ProfileFormHandler.value.login" -> "",
    "/atg/userprofiling/ProfileFormHandler.value.password" -> "prueba123",
    "_D:/atg/userprofiling/ProfileFormHandler.value.password" -> "",
    "/atg/userprofiling/ProfileFormHandler.newProcessLoginP" -> "Ingresar",
    "_D:/atg/userprofiling/ProfileFormHandler.newProcessLoginP" -> "",
    "/atg/userprofiling/ProfileFormHandler.loginSuccessURL" -> "/",
    "_D:/atg/userprofiling/ProfileFormHandler.loginSuccessURL" -> "",
    "/atg/userprofiling/ProfileFormHandler.fromExp" -> "",
    "_D:/atg/userprofiling/ProfileFormHandler.fromExp" -> "",
    "/atg/userprofiling/ProfileFormHandler.secURL" -> "/",
    "_D:/atg/userprofiling/ProfileFormHandler.secURL" -> "",
    "_DARGS" -> "/sodimac-cl/myaccount/includes/personalLogin.jsp.loginFormOld"
  )

  private val postLogin = exec(http("Post login")
      .post("https://secure.sodimac.cl/sodimac-cl/myaccount/login")
      .queryParam("_DARGS", paramQuery)
      .formParamMap(formParam)
      .check(status)
      .extraInfoExtractor { extraInfo => List(BaseLogger.getCookiesInfo(extraInfo)) })

  private def validateDynUserId(numberDyn: String): Option[String] = {
    if (numberDyn.toDouble > 10000)
      Some(numberDyn)
    else None
  }

  private def getCookieValue(name: String, session: Session): String = {
    CookieSupport.getStoredCookies(session, BaseConfig.baseUrl).find(_.getName == name) match {
      case Some(cookie) => cookie.getValue
      case _ => throw new Exception(s"""Cookie "$name" not found!""")
    }
  }

  val useOptionValidation = exec(scn)
    .exec(getLogin)
    .exec(postLogin)
    .exec(session => {
      val cookies = validateDynUserId(getCookieValue("DYN_USER_ID",session))
      println("HEREEEE " + cookies)
      session.set("DYN_USER_ID",cookies)
      session
    })
    .exec(doIf(Option("${DYN_USER_ID}").isDefined) {
      exec(http("request_PDP")
        .get("product/1113380"))
    })

}
