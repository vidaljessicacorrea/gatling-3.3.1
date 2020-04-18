package baseConfig

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

trait CustomLogging {

  protected val consoleLogger: Logger =
    Logger(LoggerFactory.getLogger("ConsoleLogger"))
}
