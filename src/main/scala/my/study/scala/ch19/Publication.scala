package my.study.scala.ch19

/**
 * Created by tianyuzhi on 16/9/26.
 */
class Publication (val title :String)
class Book(title:String) extends Publication(title)
object Library {
  val books: Set[Book] = Set(new Book("Programming in Scala"), new Book("Walden"))
  def printBookList(info : Book=>AnyRef): Unit = {
    for (book <- books) println(info(book))
  }
}
object Customer extends App {
  def getTitle(p:Publication): String = p.title
  Library.printBookList(getTitle)
}
