### Configurations

#### A) [Http Protocol](configurations/configure_http_procols.md) 

* [Extract Extra Info from request](https://gatling.io/docs/2.3/http/http_protocol/#dumping-custom-data)

Http protocol provide a hook for dumping extra data with: 	
   
   `extraInfoExtractor(f: ExtraInfoExtractor).`

ExtraInfoExtractor is a shortcut for the function type: (ExtraInfo) => List[Any]. Thus your extractor need to return a List[Any], Any is the equivalent of Object in Scala. ExtraInfo gives you access to :

    See example: `simulations/TestLoggerExtraInfo`

* [Extract values from cookies](https://groups.google.com/forum/#!topic/gatling/gSJvlg25Thw)

There is a method to extract values from cookies using the io.gatling.http.cookie.CookieSupport

For example:

```
package loadtest

import io.gatling.core.session._
import io.gatling.http.cookie.CookieSupport

object TakeCookieFromJar {

  val baseUrl = "http://example.com"

  def apply(name: String, session: Session): String = {
    CookieSupport.getStoredCookies(session, baseUrl).find(_.getName == name) match {
      case Some(cookie) => cookie.getValue
      case _ => throw new Exception(s"""Cookie "$name" not found!""")
    }
  }
}

```

    See example: `simulations/TestExtractCookieInfo`

Another way to extract cookies is using ExtraInfoExtractor

extraInfo.request.getCookies = collect all cookies in the request and return it as a List[Cookies]

After than you can manipulate the list with for statement and extract the data.

```
 val cookieVar = extraInfo.request.getCookies
    var result = ""
    for(i <- 0 to cookieVar.size() -1) {
      if (cookieVar.get(i).getName.equals("JSESSIONID")) result = cookieVar.get(i).getName + ": " + cookieVar.get(i).getValue
      if (cookieVar.get(i).getName.equals("DYN_USER_ID")) result = result + ", "+ cookieVar.get(i).getName + ": " + cookieVar.get(i).getValue
    }
    logger.info(result)
```


* Extract Header

To save the header information, you can use the check and ask for the header value that you need, for example:

```
  val getHeader_save =
    exec(http("GetHeader")
      .get("/")
      .check(header("Date").saveAs("DATE")))
```

#### B) Logger

From SLF4J user manual (https://www.slf4j.org/manual.html#binding)

It was adedded an appender in  logback.xml to write Log File of the simulation.

```
<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file>SimulationLOG_File.log</file>
    <append>false</append>
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%-5level] %logger{15} - %msg%n%rEx</pattern>
        </encoder>
</appender>
 ```
 
with the "<appender>" we must define the name that is assigned for this type of log; in this case, as you wanted to create a file, it was named FILE and the class was specified with "ch.qos.logback.core.FileAppender"

in "<file>" we define the name and location of the file
since a folder was not defined this file will be created in the root folder with the name "SimulationLOG_File" with extension .log

in "<append>" a value of type boolean is added; If true, events are appended to the end of an existing file. Otherwise, if append is false, any existing file is truncated. The append option is set to true by default.

in "<encoder>" here you can determine the way in which an event is written to the underlying OutputStreamAppender. Encoders are described in a dedicated chapter.
if you want more information please go to this url (https://logback.qos.ch/manual/appenders.html)

 ```
 <appender-ref ref="FILE" />
 ```

then we must add the appender to the segment "<root>" that will be the one that defines how the appender will be visualized:

 ```
<root level="DEBUG">
    <appender-ref ref="CONSOLE"/>
    <appender-ref ref="FILE" />
</root>
```

 with that logback configuration we can create a  type of log file of the simulation



#### C) Gatling Config

* Grafana
From [Real Time Monitoring](https://gatling.io/docs/2.3/realtime_monitoring/) and [Gatling with Grafana and InfluxDb]
(https://www.blazemeter.com/blog/gatling-tests-monitoring-with-grafana-and-influxdb)
(see the second url if you want configure your own server Setting Up Grafana and InfluxDB)

You have to go to the project's configuration and change the data configuration:

```
src\test\resources\gatling.conf
```

If you want to use Grafana you need to remove the comments and add your configuration
```
 data {
     writers = [console, file,graphite]      # The list of DataWriters to which Gatling write simulation data (currently supported : console, file, graphite, jdbc)
     graphite {
       light = false                # only send the all* stats
       host = "THE IP FROM GRAFANA"         # The host where the Carbon server is located
       port = THE PORT                # The port to which the Carbon server listens to (2003 is default for plaintext, 2004 is default for pickle)
       protocol = "tcp"           # The protocol used to send data to Carbon (currently supported : "tcp", "udp")
       rootPathPrefix = "gatling" # The common prefix of all metrics sent to Graphite
       bufferSize = 8192          # GraphiteDataWriter's internal data buffer size, in bytes
       writeInterval = 1          # GraphiteDataWriter's write interval, in seconds
     }
   }
```