/**
 * Created by tianyuzhi on 16/9/10.
 */

package my.study.scala.ch4

import scala.collection.mutable.Map

class ChecksumAccumulator {
  var sum = 0;
  def add(b: Byte): Unit = {sum += b}
  def checksum(): Int = {
    ~(sum& 0XFF) + 1
  }
}

object ChecksumAccumulator {
  private val cache = Map[String, Int]()
  def calculator(s:String): Int = {
    if (cache.contains(s)) {
      cache(s)
    }
    else {
      val acc = new ChecksumAccumulator
      for (c<-s) {
        acc.add(c.toByte)
      }
      val cs = acc.checksum()
      cache += (s->cs)
      cs
    }
  }

}

