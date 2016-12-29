
abstract class Expr
case class Number(n:Int) extends Expr
case class Sum(e1:Expr, e2:Expr) extends Expr

def eval(e:Expr): Int = e match {
  case Number(n) => n
  case Sum(l,r) => eval(l) + eval(r)
}


abstract class IntTree
case object EmptyTree extends IntTree
case class Node(elem:Int, left:IntTree, right:IntTree) extends IntTree

def contains(t:IntTree, v:Int) : Boolean = t match {
    case EmptyTree => false
    case Node(elem, left, right) =>
      if (elem == v) {
        true
      }
      else if (v < elem) {
        contains(left, v)
      }
      else {
        contains(right, v)
      }
}

def insert(t:IntTree, v:Int): IntTree = t match {
  case EmptyTree => Node(v, EmptyTree, EmptyTree)
  case Node(elem, left, right) =>
    if (elem == v) {
      this
    }
    else if (v < elem) {
      this = new Node(elem, insert(left, v), right)
    }
    else {
      this = new Node(elem, left, insert(right, v))
    }
}
