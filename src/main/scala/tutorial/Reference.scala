package tutorial

/**
 * Created by tianyuzhi on 16/10/8.
 */
class Reference[T] {
  private var contents: T = _

  def set(value:T): Unit = {
    contents = value
  }

  def get:T = contents
}

object IntegerReference {
  def main(args: Array[String]) {
    val cell = new Reference[Int]
    cell.set(13)
    println("Reference contains the half of " + (cell.get * 2 ))
  }
}
