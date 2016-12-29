
abstract class Expr1 {
  def isNumber:Boolean
  def isSum: Boolean
  def numValue:Int
  def leftOp: Expr1
  def rightOp: Expr1
}

class Number1(n:Int) extends Expr1 {
  def isNumber:Boolean = true
  def isSum:Boolean = false
  def numValue:Int = n
  def leftOp:Expr1 = sys.error("Number.leftOp")
  def rightOp:Expr1 = sys.error("Number.rightOp")
}

class Sum1(e1: Expr1, e2:Expr1) extends Expr1 {
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def numValue:Int = sys.error("Sum.numValue")
  def leftOp:Expr1 = e1
  def rightOp:Expr1 = e2
}

def eval(e:Expr1) : Int = {
  if (e.isNumber) e.numValue
  else if (e.isSum) eval(e.leftOp) + eval(e.rightOp)
  else sys.error("unrecognized expression kind")
}


abstract class Expr {
  def eval: Int
}

class Number(n:Int) extends Expr {
  def eval : Int = n
}

class Sum(e1:Expr, e2:Expr) extends Expr{
  def eval : Int = e1.eval + e2.eval
}

class Prod(e1:Expr, e2:Expr) extends Expr {
  def eval : Int = e1.eval * e2.eval
}