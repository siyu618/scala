def sumInts(a:Int, b:Int) : Int =
  if (a>b) 0 else a + sumInts(a+1, b)

def square(x:Int): Int = x * x
def sumSquares(a:Int, b:Int): Int =
  if (a>b) 0 else square(a) + sumSquares(a+1, b)

def powerOfTwo(x:Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x-1)
def sumPowersOfTwo(a:Int, b:Int): Int =
  if (a>b) 0 else powerOfTwo(a) + sumPowersOfTwo(a+1, b)

def sum(f: Int=> Int, a: Int, b: Int) : Int = {
  if (a > b) 0 else f(a) + sum(f, a+1, b)
}

def sumInts2(a:Int, b: Int): Int = sum((x:Int) => x, a, b)
def sumSquares2(a:Int, b: Int): Int = sum((x:Int) => x * x, a, b)

// currying
def sum2(f:Int => Int):(Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a>b) 0 else f(a) + sumF(a+1, b)
  sumF
}

def sumInts2 = sum2(x => x)
def sumSquares2 = sum2(x => x * x)
def sum_tail(f:Int => Int)(a: Int, b: Int): Int = {
  def iter(a: Int, result: Int): Int = {
    if (a > b) result
    else iter(a+1, result + f(a))
  }
  iter(a, 0)
}
sum2((x) => x)( 1,6)


def product(f: Int => Int):(Int, Int) => Int = {
  def productF(a: Int, b: Int) : Int = {
    if (a > b) 1
    else f(a) * productF(a+1, b)
  }
  productF
}
product(x=>x)(3,5)

def generalized(f: Int => Int, g:(Int, Int) => Int, k: => Int):(Int, Int) => Int = {
  def generalizedF(a: Int, b: Int) : Int = {
    if (a > b) k
    else g(f(a), generalizedF(a+1, b))
  }
  generalizedF
}
generalized(x => x, (a, b)=> a + b, 0)(1,6)

generalized(x => x, (a, b)=> a * b, 1)(3,5)

def generalized2(f: Int => Int)(g:(Int, Int) => Int)(k: => Int)(a: Int, b:Int): Int = {
  def generalized2F(a: Int, b: Int) : Int = {
    if (a > b) k
    else g(f(a), generalized2F(a+1, b))
  }
  generalized2F(a, b)
}
generalized2(x => x)((a, b)=> a + b)(0)(1,6)

generalized2(x => x)((a, b)=> a * b)(1)(3,5)

// 5.3
def abs(x:Double) = if (x > 0) x else -x
val tolerance = 0.0001
def isCloseEnough(x:Double, y: Double) =
  abs((x-y)/x) < tolerance
def fixedPoint(f:Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double) : Double = {
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}

def sqrt(x:Double) = fixedPoint(y=> (y+x/y)/2)(1.0)
sqrt(2)
def cureRoot(x:Double) = fixedPoint(y => (x/y/y + 2 * y)/3)(1.0)
cureRoot(8)
cureRoot(9)
cureRoot(2)
cureRoot(3)

