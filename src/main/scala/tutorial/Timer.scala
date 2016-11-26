package tutorial

/**
 * Created by tianyuzhi on 16/10/8.
 */
object Timer {
   def oncePerSecond(callback: () => Unit): Unit = {
     while (true) {
       callback()
       Thread sleep 1000
     }
   }

  def timeFlies(): Unit = {
    println("time flies like an arrow...")
  }

  def main(args: Array[String]) {
    //oncePerSecond(timeFlies)
    oncePerSecond(
      () => println("time flies like an arrow...")
    )
  }
}

