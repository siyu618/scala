import scala.util.control.NonFatal

trait M[T] {
  def flatMap[U](f: T=>M[U]) : M[U]
}
def unit[T](x:T): M[T]

unit(x) = List(x)

abstract class Option[+T] {
  def flatMap[U](f:T=>Option[U]): Option[U]
   = this match {
    case Some(x) => f(x)
    case None => None
  }
}

abstract class Try [+T]
case class Success[T](x:T) extends Try
case class Failure(ex:Exception) extends Try[Nothing]


object Try {
  def apply[T](expr: => T) :Try[T] = {
    try Success(expr)
    catch {
      case NonFatal(ex) => Failure(ex)
    }
  }
}