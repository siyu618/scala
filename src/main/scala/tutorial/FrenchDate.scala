package tutorial

import java.util.{Date, Locale}
import java.text.DateFormat
import java.text.DateFormat._
/**
 * Created by tianyuzhi on 16/10/8.
 */
object FrenchDate {

  def main (args: Array[String]) {
    val now = new Date
    val df = getDateInstance(LONG, Locale.FRENCH)
    println(df format now)
  }
}
