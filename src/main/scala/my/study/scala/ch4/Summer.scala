package my.study.scala.ch4

/**
 * Created by tianyuzhi on 16/9/11.
 */
import ChecksumAccumulator.calculator

object Summer {
  def main(args: Array[String]): Unit = {
    for (arg <- args) {
      println(arg + ":" + calculator(arg) )
    }
  }

}
