case class Book(title:String, authors: List[String])

val books: List[Book] = List(
  Book("Structure", List("Abelson", "Sussman")),
  Book("Principles", List("Aho", "Ullman")),
  Book("Programming", List("Wirth", "Sussman")),
  Book("Functional Program", List("Bird")),
  Book("The Java", List("Gosling", "Joy", "Steele", "Bracha"))
)

for (b <- books; a <- b.authors if a startsWith "Ullman")
  yield b.title

for (b <- books; if (b.title indexOf "Program") >= 0)
  yield b.title

for (b1 <- books; b2 <- books if b1 != b2;
     a1 <- b1.authors; a2 <- b2.authors if a1 == a2)
  yield a1


def removeDuplicates[A](xs: List[A]): List[A] =
  if (xs.isEmpty) xs
  else xs.head :: removeDuplicates(xs.tail filter (x => x != xs.head))


removeDuplicates(
  for (b1 <- books; b2 <- books if b1 != b2;
       a1 <- b1.authors; a2 <- b2.authors if a1 == a2)
    yield a1
)


object Demo {
  def map[A,B](xs: List[A], f: A => B): List[B] =
    for (x <- xs) yield f(x)

  def flatMap[A,B](xs:List[A], f: A => List[B]): List[B] =
    for (x <- xs; y <- f(x)) yield y

  def filter[A](xs:List[A], p: A => Boolean): List[A] =
    for (x <- xs if p(x)) yield x
}

def flatten[A](xss: List[List[A]]): List[A] =
  (xss :\ (Nil: List[A])) ((xs,ys) => xs ::: ys)

def flatten_for[A](xss: List[List[A]]): List[A] =
  for (xs <- xss; x <- xs) yield x


books.map(x => (if (!x.authors.filter(y => y.startsWith("Bird")).isEmpty) x.title))

books.flatMap(x => x.authors.filter(y => y.startsWith("Bird")).map(z => x.title))

//books.flatMap(x => (x.authors.filter(y => y.startsWith("Bird")).map()))


books.filter(x => (x.title indexOf "Program") >= 0)
  .map(x => x.title)




