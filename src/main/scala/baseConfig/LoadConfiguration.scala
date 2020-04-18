package baseConfig


object LoadConfiguration extends CustomLogging{

  val totalUsers = System.getProperty("gatling.totalUsers").toInt
  val totalTimeMin = System.getProperty("gatling.totalTimeMin").toInt
  val baseUrl = System.getProperty("gatling.url")
  val usersPerSec = totalUsers / totalTimeMin
  val pauseTime = System.getProperty("gatling.pause").toInt
  val gatlingResourceFolder = "src/test/resources/data/"


  consoleLogger.info("############################################")
  consoleLogger.info("# Web Simulation Parameters ")
  consoleLogger.info("# Base Url: %s".format(baseUrl))
  consoleLogger.info("# Total Users: %s".format(totalUsers))
  consoleLogger.info("# Total Time: %s min".format(totalTimeMin))
  consoleLogger.info("# Users per sec: %s".format(usersPerSec))
  consoleLogger.info("############################################")

}
