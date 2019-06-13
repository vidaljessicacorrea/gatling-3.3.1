Extract Header and write Log File
=================================

From SLF4J user manual (https://www.slf4j.org/manual.html#binding)

it was adedded an appender in  logback.xml to write Log File of the simulation.
```
<appender name="FILE" class="ch.qos.logback.core.FileAppender">
    <file> SimulationLOG_File.log</file>
    <append>false</append>
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%-5level] %logger{15} - %msg%n%rEx</pattern>
        </encoder>
</appender>
 ```
Explanation:
================

with the "<appender>" we must define the name that is assigned for this type of log; in this case, as you wanted to create a file, it was named FILE and the class was specified with "ch.qos.logback.core.FileAppender"

in "<file>" we define the name and location of the file
since a folder was not defined this file will be created in the matrix folder with the name "SimulationLOG_File" with extension .log

in "<append>" a value of type bolean is added; If true, events are appended to the end of an existing file. Otherwise, if append is false, any existing file is truncated. The append option is set to true by default.

in "<encoder>" here you can determine the way in which an event is written to the underlying OutputStreamAppender. Encoders are described in a dedicated chapter.
if you want more infomation please go to this url (https://logback.qos.ch/manual/appenders.html)

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


to save the header information, i used this way to  extract and saved the header as a variable in the file ScenarioTest

```
  val getHeader_save =
    exec(http("GetHeader")
      .get("/")
      .check(header("Date").saveAs("DATE")))
```

and then create a chainbuilder variable to store the information extracted from the header in the log file (the type of log can be defined within the logger value)
```
  val getLogger : ChainBuilder = {
    exec(session =>{
      val url = "********************************"+session("DATE").as[String]+"**************************"
      logger.debug(url)
      session
    }
    )
  }
```