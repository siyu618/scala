import scala.annotation.tailrec


val fruit = List("apples", "oranges", "pears")
val nums= List(1,2,3,4)
val diag3 = List(List(1,0,0), List(0,1,0), List(0,0,1))
val empty = List()
val dummy = List("123", 123, None, new AnyRef)
// head, tail, isEmpty
empty.isEmpty
fruit.isEmpty
fruit.head
fruit.tail.head
diag3.head
def isort(xs: List[Int]): List[Int] =
  if (xs.isEmpty) List[Int]()
  else insert(xs.head, isort(xs.tail))
//@tailrec: not ok
def insert(x:Int, xs:List[Int]):List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
}
//def insert(x:Int, list: List[Int]): List[Int]  =
//  if (list.isEmpty) {
//    List(x)
//  }
//  else {
//    if (x <= list.head) {
//      x :: list
//    }
//    else {
//      var res = List[Int]()
//      var tmp:List[Int] = list
//      while (!tmp.isEmpty && tmp.head < x) {
//        res = res ++  (tmp.head :: Nil)
//        tmp = tmp.tail
//      }
//      if (!tmp.isEmpty)
//        res = res ++ tmp
//    }
//  }

isort(List(5,3,-4,5,1,9,8))

//
//abstract class List2[+A] {
//  def isEmpty:Boolean  = this match {
//    case Nil => true
//    case x::xs => false
//  }
//  def head: A = this match {
//    case Nil => sys.error("Nil.head")
//    case x :: xs => x
//  }
//  def tail: List[A] = this match {
//    case Nil => sys.error("Nil.tail")
//    case x :: xs => xs
//  }
//  def length:Int = this match {
//    case Nil => 0
//    case x :: xs => 1 + xs.length
//  }
//
//  @tailrec
//  final def length2 = {
//    def length_r(xs:List[Int], len: Int): Int = xs math {
//      case Nil => len
//      case x :: xs => length_r(xs, len + 1)
//    }
//    length_r(this, 0)
//  }
//}

def length2(list : List[Int]) = {
     @tailrec
     def length_r(xs:List[Int], len: Int): Int = xs match {
      case Nil => len
      case x :: xs => length_r(xs, len + 1)
    }
    length_r(list, 0)
}

length2(List())
length2(List(1, 2))


// reverse list

def reverse_list(xs:List[Int]): List[Int] = {
  @tailrec
  def reverse_list(list:List[Int], res:List[Int]): List[Int] = {
    list match {
      case Nil => res
      case x :: xs => reverse_list(xs, x :: res)
    }
  }
  reverse_list(xs, Nil)
}

reverse_list(List(1,2,4))
reverse_list(List(3,5,8))
reverse_list(List())


// msort

def msort[A](less:(A,A)=>Boolean)(xs:List[A]): List[A] = {
  def merge(xs1:List[A], xs2:List[A]): List[A] =
    if (xs1.isEmpty) xs2
    else if (xs2.isEmpty) xs1
    else if (less(xs1.head, xs2.head)) xs1.head :: merge(xs1.tail, xs2)
    else xs2.head :: merge(xs1, xs2.tail)

  val n = xs.length / 2
  if (n == 0) xs
  else merge(msort(less)(xs take n), msort(less)(xs drop n))

}


def squareList(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => y*y :: squareList(ys)
}

def squareList2(xs: List[Int]): List[Int] =
  xs map (x => x*x)

squareList(List(1,2,3))
squareList2(List(1,2,3))

List.range(1,7)
  .map(i => List.range(1,i).map(x => (i, x)))
  .foldRight(List[(Int,Int)]() {(xs,ys) =? xs ::: ys}.filter(pair => isPrime)