
case class TwoInts(first: Int, second: Int)
def divmod(x: Int, y: Int): TwoInts = new TwoInts(x/y, x%y)

case class Tuple2[A, B](_1:A, _2:B)
def divmod2(x:Int, y:Int) = new Tuple2[Int, Int](x/y, x%y)

val x = 23
val y = 3
val xy = divmod2(x,y)
println("quotient:" + xy._1 + ", rest:" + xy._2)
divmod(x, y) match {
  case TwoInts(n, d) =>
    println("quotientx:" + n + ", rest:" + d)
}
divmod2(x, y) match {
  case Tuple2(n, d) =>
    println("quotient:" + n + ", rest:" + d)
}


def divmod3(x:Int, y:Int): (Int, Int) = (x/y, x%y)

divmod3(x,y) match {
  case (n,d) => println("quotient:" + n + ", rest:" + d)
}



