package my.study.scala.ch18

/**
 * Created by tianyuzhi on 16/9/23.
 */
class Thermometer {
  var celsius : Float = _
  def fahrenheit = {
    println("fahrenheit invoked")
    celsius * 9 / 5  + 32
  }
  def fahrenheit_=(f:Float): Unit = {
    println("fahrenheit_ invoked")
    celsius = (f-32)*5 /9
  }
  override def toString = fahrenheit + "F/" + celsius + "C"

}
