package my.study.scala.ch10

/**
 * Created by tianyuzhi on 16/9/15.
 */
abstract class Element2 {
  def contents: Array[String]
  val height = if (null != contents) contents.length else 0
  val width = if (height == 0 || contents.length < 1) 0 else contents(0).length

  def above(that:Element2)  = {
    val this1 = this widen that.width
    val this2 = that widen this.width
    Element2.elem(this.contents ++ that.contents)
  }

  def beside(that:Element2) = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    Element2.elem (
      for ((line1, line2) <- this1.contents zip that1.contents)
        yield line1 + line2
    )
  }

  def widen(w:Int) : Element2 = {
     if (w <= width) this
     else {
       val left = Element2.elem(' ', (w-width)/2, height)
       val right = Element2.elem(' ', (w-width-left.width), height)
       left beside this beside right
     }
  }

  def heighten(h:Int) : Element2 = {
    if (h<=height) this
    else {
      val top = Element2.elem(' ', width, (h-height)/2)
      val bot = Element2.elem(' ', width, h - height - top.height)
      top above this above bot
    }
  }

  override def toString = contents mkString "\n"

}

object Element2 {
  private class ArrayElement (
     val contents : Array[String]) extends Element2
  private class LineElement(s:String) extends Element2 {
    val contents = Array(s)
    override val width = s.length
    override val height = 1
  }
  private class UniformElement (
    ch:Char,
    override val width : Int,
    override val height : Int
  ) extends Element2 {
    private val line = ch.toString * width
    def contents = Array.empty
  }

  def elem(contents: Array[String]) : Element2 =
    new ArrayElement(contents)
  def elem(chr:Char, width:Int, height:Int): Element2 =
    new UniformElement(chr, width, height)
  def elem(line:String): Element2 = new LineElement(line)
}

