package my.study.scala.ch28

/**
 * Created by tianyuzhi on 16/9/30.
 */
trait Tree[+T] {
  def elem : T
  def left : Tree[T]
  def right : Tree[T]
}

object EmptyTree extends Tree[Nothing] {
  def elem =
    throw new NoSuchElementException("Empty tree")

  def left =
    throw new NoSuchElementException("Empty tree")

  def right =
    throw new NoSuchElementException("Empty tree")
}

class Branch[+T] (
  val elem:T,
  val left : Tree[T],
  val right : Tree[T]
) extends Tree[T] {
  override def equals(other :Any ) = other match  {
    case that:Branch[T] =>
      this.elem == that.elem && this.left == that.left && this.right == that.right
    case _ => false
  }

  override def hashCode : Int =
      41 * (41 * (41 + elem.hashCode) + left.hashCode) + right.hashCode

  def canEqual(other:Any) = other match {
    case that: Branch[_] => true
    case _ => false
  }
}
