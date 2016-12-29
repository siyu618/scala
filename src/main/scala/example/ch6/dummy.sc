import scala.reflect.internal.TreeInfo.IsFalse

class Rational(n: Int, d: Int) {
  private def gcd(x: Int, y: Int): Int = {
    if (x == 0) y
    else if (x < 0) gcd(-x, y)
    else if (y < 0) -gcd(x, -y)
    else gcd(y % x, x)
  }

  private val g = gcd(n, d)
  val numer: Int = n / g
  val denom: Int = d / g

  def +(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def -(that: Rational) =
    new Rational(numer * that.denom - that.numer * denom,
      denom * that.denom)

  def *(that: Rational) =
    new Rational(numer * that.numer, denom * that.denom)

  def /(that: Rational) =
    new Rational(numer * that.denom, denom * that.numer)
  override def toString = "" + numer.toString + "/" + denom.toString

  def square = new Rational(numer* numer, denom * denom)
}

var i = 1
var x = new Rational(0,1)
while (i <= 10) {
  x += new Rational(1,i)
  i += 1
}
x
val strVal = x
println(x)

val y : AnyRef = new Rational(1,2)

val r = new Rational(3,4)
println(r.square)

trait IntSet {
  def incl(x:Int): IntSet
  def contains(x:Int): Boolean
  def union(anotherSet:IntSet): IntSet
  def intersection(anotherSet:IntSet): IntSet
  def excl(anotherSet:Int): IntSet
  def isEmpty(): Boolean
}

class EmptySet extends IntSet {
  def contains(x:Int): Boolean = false
  def incl(x:Int): IntSet = new NonEmptySet(x, new EmptySet, new EmptySet)
  override def union(anotherSet:IntSet): IntSet = anotherSet
  override def intersection(anotherSet:IntSet): IntSet = this
  override def isEmpty(): Boolean = false
  override def excl(x:Int):IntSet = this

}

class NonEmptySet(elem:Int, left:IntSet, right:IntSet) extends IntSet {
  override def isEmpty = false
  def contains(x:Int) : Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x:Int):IntSet = {
    if (x<elem) new NonEmptySet(elem, left incl x, right)
    else if (x>elem) new NonEmptySet(left, left, right incl x)
    else this
  }
  override def union(anotherSet:IntSet): IntSet = {
    if (anotherSet.isInstanceOf[EmptySet]) {
      this
    }
    else {
      val nSet = anotherSet.asInstanceOf[NonEmptySet]
      this incl nSet.elem
      this union  nSet.left
      this union  nSet.right
    }
  }

  override def excl(x:Int): IntSet = {
    if (!contains(x)) {
      this
    }
    else {
      if (x == elem) {
        this = left union right
      }
      else if (x < elem) {
        this = new NonEmptySet(elm, left excl x, right)
      }
      else {
        this = new NonEmptySet(elem, left, right excl x)
      }
    }
  }
}
