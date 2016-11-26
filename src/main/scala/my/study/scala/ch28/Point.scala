package my.study.scala.ch28

/**
 * Created by tianyuzhi on 16/9/30.
 */
class Point(val x: Int, val y: Int) {
  def equals(other: Point): Boolean =
    this.x == other.x && this.y == other.y

  override def equals(other: Any): Boolean = {
    other match {
      case that: Point => this.x == that.x && this.y == that.y
      case _ => false
    }
  }

  override def hashCode = 41 * (41 + x) + y
  def canEqual(other : Any) = other.isInstanceOf[Point]

}

object MyColor extends Enumeration {
  val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
}

class ColoredPoint(x: Int, y: Int, val color: MyColor.Value) extends Point(x, y) {
  override def equals(other: Any) = other match {
    case that: ColoredPoint =>
      (that canEqual this) &&
      this.color == that.color && super.equals(that)
    case _ => false
  }
  override def canEqual(other : Any) = other.isInstanceOf[ColoredPoint]

}

