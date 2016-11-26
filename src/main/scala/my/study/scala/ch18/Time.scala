package my.study.scala.ch18

/**
 * Created by tianyuzhi on 16/9/23.
 */
class Time {

  private[this] var h = 12
  private [this] var m = 0
  def hour:Int = h
  def hour_=(x:Int): Unit = {
    require(x >= 0 && x <24)
    h = x
  }

  def minute:Int = m
  def minute_=(x:Int): Unit = {
    require(x >=0 && x < 60)
    m = x
  }

}
