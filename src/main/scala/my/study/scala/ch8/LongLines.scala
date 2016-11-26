package my.study.scala.ch8

import scala.io.Source

/**
 * Created by tianyuzhi on 16/9/12.
 */
object LongLines {



  def processFile(fileName: String , width:Int): Unit = {
     def processLine(line: String) = {
      if (line.length > width)
        println(fileName + " : " + line)
    }

    val source = Source.fromFile(fileName)
    for (line<-source.getLines) {
      processLine(line)
    }
  }

}

object FindLongLines {
  def main(args: Array[String]) {
    val width = args(0).toInt
    for (arg <- args.drop(1)) {
      LongLines.processFile(arg, width)
    }
  }
}
