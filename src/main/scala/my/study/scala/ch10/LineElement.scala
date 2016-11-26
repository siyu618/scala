package my.study.scala.ch10

/**
 * Created by tianyuzhi on 16/9/15.
 */
class LineElement(s:String) extends ArrayElement(Array(s)){
  override val width = s.length

   override val height = 1


}
