package my.study.scala.ch9

/**
 * Created by tianyuzhi on 16/9/15.
 */
object Assertion {

  var assertionsEnabled = false

//  def myAssert(predicate: () => Boolean)  =
//    if (assertionsEnabled && ! predicate)
//      throw new AssertionError

  def byNameAssert(predicate: => Boolean) =
    if (assertionsEnabled && ! predicate)
      throw new AssertionError

}
