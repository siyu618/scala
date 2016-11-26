package my.study.scala.ch4

/**
 * Created by tianyuzhi on 16/9/11.
 */
import ChecksumAccumulator.calculator
object ForWinterSpringSummer extends App {
  for (season <- List("fall" , "winter", "spring")) {
    println(season + ":" + calculator(season))
  }
}