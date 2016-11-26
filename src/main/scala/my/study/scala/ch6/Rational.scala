package my.study.scala.ch6

/**
 * Created by tianyuzhi on 16/9/11.
 */
class Rational(n:Int, d:Int) {
  require(d!=0)

  private val g:Int = gcd(n,d)
  val number:Int = n/g
  val denom:Int = d/g
  def this(n:Int) = this(n,1)

  override def toString= number + "/" + d
  def add(that : Rational): Rational =  {
    new Rational(
       number * that.denom + that.number* denom,
      denom * that.denom
    )
  }
  def +(that:Rational) = add(that)

  def lessThan(that:Rational) = this.number * that.denom < that.number * this.denom
  def max(that:Rational) = if (this.lessThan(that)) that else this

   def gcd(a:Int, b:Int): Int = {
    if (b == 0) a
    else gcd(b, a%b)
  }

  def main (args: Array[String]) {
    val oneHalf = new Rational(2,4)
    println(oneHalf)
    println(oneHalf.gcd(2,4))
  }
}
