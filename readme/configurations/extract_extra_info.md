Extract Extra Info Test
============================

From [Http Protocol] (https://gatling.io/docs/2.3/http/http_protocol/)

##Log extra data from request

Http protocol provide a hook for dumping extra data with: 	
   
   `extraInfoExtractor(f: ExtraInfoExtractor).`

ExtraInfoExtractor is a shortcut for the function type: (ExtraInfo) => List[Any]. Thus your extractor need to return a List[Any], Any is the equivalent of Object in Scala. ExtraInfo gives you access to :

* requestName: The name of the request.
* status: The status of the request, i.e. OK/KO.
* session: The user’s Session.
* request: The http request.
* response: The http response.

If you don't use a logger, the extra data could be appended to the relative records in the simulation.log file and reports generation will ignore them. It’s up to the user to build his own analysis system for them.

For example, it you’d like the dump the response body’s length to simulation.log, you would do:
``
val httpProtocol = http.extraInfoExtractor(extraInfo => List(extraInfo.response.bodyLength))
``

If you log your Object using for example, slf4j:
```
def loggerInfo(extraInfo: ExtraInfo) {
    val url = "[" + extraInfo.requestName + "],[" + extraInfo.status + "],[" + extraInfo.request.getMethod + "],[" + extraInfo.response.statusCode.get + "]"
    logger.info(url.toString)
  }
val extraInfo = scenario("ExtraInfo")
    .exec(http("request_2")
      .get("/")
      .extraInfoExtractor { extraInfo => List(BaseLogger.loggerInfo(extraInfo))})
```      
      
Gatling provides a built-in ExtraInfoExtractor, dumpSessionOnFailure, which dumps the user’s session to simulation.log if the request failed.

