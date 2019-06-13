package baseConfig

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

trait GatlingLogging {

  protected val fileLogger: Logger =
    Logger(LoggerFactory.getLogger("FileLogger"))

  protected val consoleLogger: Logger =
    Logger(LoggerFactory.getLogger("ConsoleLogger"))

}
