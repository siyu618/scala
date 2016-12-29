import scala.collection

val it: Iterator[Int] = Iterator.range(1, 10)
while (it.hasNext) {
  val x = it.next
  println(x * x)
}

class A

