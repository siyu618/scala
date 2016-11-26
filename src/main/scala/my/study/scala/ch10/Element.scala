package my.study.scala.ch10

/**
 * Created by tianyuzhi on 16/9/15.
 */
abstract class Element {
    def contents: Array[String]
    val height = contents.length
    val width = if (height == 0) 0 else contents(0).length
    def above(that:Element) = new ArrayElement(this.contents ++ that.contents)
    def beside(that:Element) = new ArrayElement(
      for ((line1, line2) <- this.contents zip that.contents)
        yield line1 + line2)
    override def toString = contents mkString "\n"
}

object Element {

}