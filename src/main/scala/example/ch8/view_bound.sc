

trait Ordered[A] {
  def compare(that: A): Int
  def <(that: A): Boolean = (this compare that) < 0

  def >(that: A): Boolean = (this compare that) > 0

  def <=(that: A): Boolean = (this compare that) <= 0

  def >=(that: A): Boolean = (this compare that) >= 0

  def compareTo(that: A): Int = compare(that)
}

trait Set[A <: Ordered[A]] {
  def incl(x: A): Set[A]
  def contains(x: A): Boolean
}

class EmptySet[A <: Ordered[A]] extends Set[A] {
  def contains(x: A): Boolean = false
  def incl(x: A): Set[A] =
     new NonEmptySet(x, new EmptySet[A], new EmptySet[A]())
}

class NonEmptySet[A <: Ordered[A]]
(elem: A, left: Set[A], right: Set[A]) extends Set[A] {
  def contains(x: A): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x:A): Set[A] =
    if (x < elem) new NonEmptySet[A](elem, left incl x, right)
    else if (x > elem) new NonEmptySet[A](elem, left, right incl x)
    else this
}


case class Num(value:Double) extends Ordered[Num] {
  def compare(that:Num): Int =
    if (this.value < that.value) -1
    else if (this.value > that.value) 1
    else 0
}

val s = new EmptySet[Num].incl(Num(1.0)).incl(Num(2.0))
s.contains(Num(1.5))

// the following will fail
//val s3 = new EmptySet[java.io.File]




