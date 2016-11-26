package my.study.scala.ch19

/**
 * Created by tianyuzhi on 16/9/26.
 */
class Queue1[T] private (
   private val leading:List[T],
   private val trailing:List[T]) {

  def this() = this(Nil, Nil)
  //def this(elems:T*) = this(elems.toList, Nil)

  private def mirror =
    if (leading.isEmpty)
      new Queue1(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head
  def tail = {
    val q = mirror
    new Queue1(q.leading.tail, q.trailing)
  }

  def append(x:T) =
    new Queue1(leading, x::trailing)



}

object Test {
  def main(args: Array[String]) {
    new Queue1()
    //new Queue1(List(1,2), List(3,4))
    //new Queue1(1,2,3)
  }
}
