package my.study.scala.ch9

/**
 * Created by tianyuzhi on 16/9/13.
 */
object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatching(matcher: String=>Boolean)  =
    for (file <-filesHere; if matcher(file.getName)) yield file

  def filesEnding(query:String) =
    filesMatching(_.endsWith(query))
  def filesContaining(query:String) =
    filesMatching(_.contains(query))
  def filesRegex(query:String) =
    filesMatching(_.matches(query))


  def main(args: Array[String]) {
    FileMatcher.filesContaining("scala")
    FileMatcher.filesEnding("scala")
    FileMatcher.filesRegex(".*.scala")
  }


}
