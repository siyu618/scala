import java.util.Random
val rand = new Random
rand.nextInt()

trait Generator[+T] {
  self =>
  def generate:T

  def map[S](f:T=>S) : Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate)
  }

  def flatMap[S](f:T=>Generator[S]): Generator[S] = new Generator[S] {
    override def generate: S = f(self.generate).generate
  }

}

val integers = new Generator[Int] {
  val rand = new Random
  def generate = rand.nextInt
}

val booleans = new Generator[Boolean] {
  def generate = integers.generate > 0
}

val pairs = new Generator[(Int, Int)] {
  def generate = (integers.generate, integers.generate)
}

integers.generate
integers.generate

booleans.generate
booleans.generate
pairs.generate


val booleans2 = for (x <- integers) yield x > 0
booleans2.generate

def single[T](x:T):Generator[T] = new Generator[T] {
  override def generate: T = x
}

def choose(lo:Int, hi:Int) : Generator[Int] =
  for (x <- integers) yield  lo + x % (hi-lo)

def onOf[T](xs:T*):Generator[T] =
  for (idx <- choose(0, xs.length)) yield xs(idx)


def lists: Generator[List[Int]] = for {
  isEmpty <- booleans2
  list <- if (isEmpty) emptyLists else nonEmptyLists
} yield list

def emptyLists = single(Nil)

def nonEmptyLists = for {
  head <- integers
  tail <- lists
} yield head :: tail

lists
lists.generate



trait Tree
case class Inner(left:Tree, right:Tree) extends Tree
case class Leaf(x:Int) extends Tree

def leafs: Generator[Leaf] = for {
  x <- integers
} yield Leaf(x)

def inners:Generator[Inner] = for {
  l<- trees
  r<-trees
} yield Inner(l,r)

def trees:Generator[Tree] = for {
  isLeaf <- booleans2
  tree <- if (isLeaf) leafs else inners
} yield tree

trees.generate


def test[T](g:Generator[T], numTimes:Int=100)
           (test:T=>Boolean) :Unit= {
  for (i<- 0 until numTimes) {
    val value = g.generate
    assert(test(value), "test failed for " + value)
  }
  println("passed " + numTimes + " tests")
}

test(booleans2, 10)(x => true)







