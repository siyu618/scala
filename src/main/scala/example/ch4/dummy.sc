87 + 145
5 + 3*2
"Hello" + " world"
def scale = 5
7 * scale
def pi = 3.1415926
def radius = 10
2 * pi * radius
def a = 10 + 5
def b = 2 * 3
a * b

def square(x:Double) = x * x
square(3)
square(3+5)
square(square(4))

def sumOfSquares(x:Double, y:Double) = square(x) + square(y)
sumOfSquares(3,4)

def loop : Int = loop
def first(x:Int, y:Int) = x

// deep loop, scala uses call-by-value by default
// when comes with => , it uses call-by-name
//first(1,loop)

def constOne(x:Int, y: => Int) = 1
constOne(1,1)
constOne(1, loop)
//constOne(loop, 1)// infinite loop

def abs(x:Double) = if (x >= 0) x else -x
abs(1)
abs(-10)

def improve(guess:Double, x:Double) =
  (guess + x / guess) / 2

def isGoodEnough(guess:Double, x:Double) =
  abs(square(guess) - x) < 0.0001

def sqrtIter(guess:Double, x:Double) : Double =
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)

def sqrt(x:Double) = sqrtIter(1.0, x)
sqrt(1.0)
sqrt(0.9)
sqrt(1.2)
sqrt(4)

def f(x:Int) = x + 1;
f(1) + f(2)

def g1(x:Int) = x + 1
g1(1) + g1(1)

def g2(x:Int) = {x + 1}; g2(1) + g2(2)

def h1(x:Int) =
  x +
  x
h1(1) * h1(2)
def h2(x:Int) = (
  x
  +
  x
  )
h2(1)/h2(2)

// tail recursion
def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)
factorial(5)

def factorial_tail(n:Int): Int = {
  def factorial_iter(res:Int, n:Int): Int = {
    if (n == 0) res else factorial_iter(res * n, n - 1)
  }
  factorial_iter(1, n)
}
factorial_tail(5)











