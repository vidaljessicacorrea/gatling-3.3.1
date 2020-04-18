package baseConfig

import java.text.SimpleDateFormat
import java.util.{Calendar}

class BaseChains {

  val rnd = new scala.util.Random
  val shortPause = 3 + rnd.nextInt(5) // 3 up to 8 seconds
  val mediumPause = 10 + rnd.nextInt(16) // 10 up to 25 seconds
  val longPause = 26 + rnd.nextInt(21)

  def getDate:String ={
    val format = new SimpleDateFormat("d-M-y")
    val date = format.format(Calendar.getInstance().getTime())
    return date
  }

}
