

// + indicates that subtyping is covariant
//>: lower bound
abstract class Stack[+A] {
  def push[B >: A](x: B): Stack[B] = new NonEmptyStack(x, this)
  def isEmpty: Boolean
  def top: A
  def pop: Stack[A]
}

object EmptyStack extends Stack[Nothing] {
  override def isEmpty = true
  override def top = sys.error("EmptyStack.top")
  override def pop = sys.error("EmptyStack.pop")
}

class NonEmptyStack[+A](elem: A, rest: Stack[A]) extends Stack[A] {
  override def isEmpty = false
  def top = elem
  def pop = rest
}


val s = EmptyStack.push("abc")
val x = s.push(new AnyRef())