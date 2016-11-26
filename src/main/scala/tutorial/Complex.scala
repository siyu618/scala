package tutorial

/**
 * Created by tianyuzhi on 16/10/8.
 */
class Complex(real:Double, imaginary:Double) {
  def re() = real
  def im() = imaginary
}

object Complex extends App{
  val comp = new Complex(1,2)
  println(comp.im)
  println(comp.re)
}
