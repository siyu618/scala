package my.study.scala.ch7

/**
 * Created by tianyuzhi on 16/9/12.
 */
object PrintMultiTable {
  def makeRowSeq(row : Int) =
    for (col <- 1 to 10) yield {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      padding + prod
    }


  def makeRow(row: Int) = makeRowSeq(row).mkString

  def muliTable() = {
    val tableSeq =
      for (row <- 1 to 10)
        yield makeRow(row)
    tableSeq.mkString("\n")
  }

  def main (args: Array[String]) {
    val table = PrintMultiTable.muliTable()
    println(table)
  }

}
