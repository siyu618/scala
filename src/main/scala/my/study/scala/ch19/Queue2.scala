//package my.study.scala.ch19
//
///**
// * Created by tianyuzhi on 16/9/26.
// */
//trait Queue2[T] {
//  def head : T
//  def tail : Queue2[T]
//  def append(x:T): Queue2[T]
//}
//
//object Queue2 {
//  def apply2[T](xs: T*) : Queue2[T] = new QueueImpl[T](xs.toList, Nil)
//
//  class QueueImpl[T] private (
//                            private val leading:List[T],
//                            private val trailing:List[T])
//  extends Queue2[T]
//  {
//
//    def this() = this(Nil, Nil)
//    //def this(elems:T*) = this(elems.toList, Nil)
//
//    private def mirror =
//      if (leading.isEmpty)
//        new QueueImpl(trailing.reverse, Nil)
//      else
//        this
//
//    def head = mirror.leading.head
//    def tail = {
//      val q = mirror
//      new QueueImpl(q.leading.tail, q.trailing)
//    }
//
//    def append(x:T) =
//      new QueueImpl(leading, x::trailing)
//
//
//
//  }
//}
