

def isSafe(col: Int, queens: List[Int], delta: Int): Boolean = {
  val len = queens.length
  for (i <- List.range(0, queens.size, delta) ){
    if (queens(i) == col || Math.abs(queens(i) - col) == len - i)
      return false
  }
  return true
}


def queens(n: Int) : List[List[Int]] = {
  def placeQueens(k: Int): List[List[Int]] =
    if (k == 0) List(List())
    else for {queens <- placeQueens(k - 1)
              column <- List.range(1, n+1)
              if isSafe(column, queens, 1)
    } yield queens ::: List(column)
    //} yield column :: queens
  placeQueens(n)
}

queens(0)
queens(1)
queens(2)
val res :List[List[Int]] = queens(8)
res.size


