package baseConfig

import io.gatling.http.request.ExtraInfo


object BaseLogger extends GatlingLogging {

  def loggerInfo(extraInfo: ExtraInfo) {
    val url = "[" + extraInfo.requestName + "],[" + extraInfo.status + "],[" + extraInfo.request.getMethod + "],[" + extraInfo.response.statusCode.get + "]"
    consoleLogger.info(url.toString)
  }

  def jsessionIDInfo(extraInfo: ExtraInfo) {
    val cookieVar = extraInfo.request.getCookies.get(0).getValue
    consoleLogger.info("JSESSIONID: " + cookieVar)
  }

  def getCookiesInfo(extraInfo: ExtraInfo) {
    val cookieVar = extraInfo.request.getCookies
    var result = ""
    for(i <- 0 to cookieVar.size() -1) {
      if (cookieVar.get(i).getName.equals("JSESSIONID")) result = cookieVar.get(i).getName + ": " + cookieVar.get(i).getValue
      if (cookieVar.get(i).getName.equals("DYN_USER_ID")) result = result + ", "+ cookieVar.get(i).getName + ": " + cookieVar.get(i).getValue
    }
    consoleLogger.info(result)
  }


}

