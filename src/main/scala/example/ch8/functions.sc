trait Function1[-A, +B] {
  def apply(x:A): B
}

// (T1, T2, ...,Tn) => S
// FunctionN[T1,T2,...,Tn,S]

val f:(AnyRef => Int) = x => x.hashCode()
val g:(String => Int) = f

print(f)


g("abc")


val plus1:(Int => Int) = (x:Int) => x + 1
plus1(1)

val plus2: Function1[Int, Int] = new Function1[Int, Int] {
  def apply(x:Int): Int = x  + 1
}
plus2(2)

val plus3:Function1[Int, Int] = {
  class Local extends Function1[Int, Int] {
    def apply(x:Int) : Int = x + 1
  }
  new Local: Function1[Int, Int]
}
plus3.apply(3)
