package my.study.scala.ch10

/**
 * Created by tianyuzhi on 16/9/15.
 */
class UniformElement (
    ch: Char,
    override val width : Int,
    override val height : Int
                       )
  extends Element
{
  private val line = ch.toString * width
  def contents = Array.empty ;//= Array.make(height, width)
}
