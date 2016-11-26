package my.study.scala.ch12

/**
 * Created by tianyuzhi on 16/9/15.
 */
abstract class IntQueue {
  def get() : Int
  def put(x:Int)
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  override def get(): Int = buf.remove(0)
  override def put(x: Int): Unit = buf += x

}

trait Doubling extends IntQueue {
  abstract override def put(x:Int) {super.put(2*x)}
}

trait Incrementing extends IntQueue {
  abstract override def put(x:Int) {super.put(x+1)}
}

trait Filtering extends IntQueue {
  abstract override def put(x:Int): Unit = {
    if (x >= 0) super.put(x)
  }
}
