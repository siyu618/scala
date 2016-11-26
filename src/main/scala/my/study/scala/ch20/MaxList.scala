package my.study.scala.ch20

/**
 * Created by tianyuzhi on 16/9/28.
 */
object MaxList {
  def maxListUpBound[T <: Ordered[T]](elements: List[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListUpBound(rest)
        if (x > maxRest) x
        else maxRest
    }

  def maxListImpParm[T](elements: List[T])
                       (implicit orderer: T=>Ordered[T]) : T=
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm(rest)(orderer)
        if (x > maxRest) x
        else maxRest
    }

  def maxListImpParm2[T <% Ordered[T]](elements: List[T]): T=
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty list")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListImpParm2(rest)
        if (x > maxRest) x
        else maxRest
    }


  def main(args: Array[String]) {
    println(maxListImpParm(List(1,2,6,10,4)))
    println(maxListImpParm(List(1.5,5,2,10.5,3.1415)))
    println(maxListImpParm(List("one", "two", "three")))

    println(maxListImpParm2(List(1,2,6,10,4)))
    println(maxListImpParm2(List(1.5,5,2,10.5,3.1415)))
    println(maxListImpParm2(List("one", "two", "three")))
  }
}
