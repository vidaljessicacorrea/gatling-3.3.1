package baseConfig

object BaseConfig {

  val totalUsers = System.getProperty("totalUser").toInt
  val totalTimeMin = System.getProperty("totalTime").toInt
  val baseUrl = System.getProperty("URL")
  val usersPerSec = totalUsers.toDouble / (60 * totalTimeMin)
  val feederPath = "src/test/resources/data/"
  val pauseTimeMin = System.getProperty("pauseTimeMin").toInt
  val pauseTimeMax = System.getProperty("pauseTimeMax").toInt

}
