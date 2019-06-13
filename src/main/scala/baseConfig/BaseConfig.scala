package baseConfig

object BaseConfig {

  val totalUsers = System.getProperty("gatling.totalUser").toInt
  val totalTimeMin = System.getProperty("gatling.totalTime").toInt
  val baseUrl = System.getProperty("gatling.URL")
  val usersPerSec = totalUsers.toDouble / 60 / totalTimeMin
  val feederPath = "src/test/resources/feeders/"
  val pauseTimeMin = System.getProperty("gatling.pauseTimeMin").toInt
  val pauseTimeMax = System.getProperty("gatling.pauseTimeMax").toInt

}
