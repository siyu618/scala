package my.study.scala.ch20

/**
 * Created by tianyuzhi on 16/9/27.
 */
object Converter {
  var exchangeRate = Map (
    "USD" -> Map("UDS"->1.0, "EUR"->0.759, "JPY"->1.211, "CHF"->1.223),
    "EUR" -> Map("UDS"->1.136, "EUR"->1.0, "JPY"->1.594, "CHF"->1.623),
    "JPY" -> Map("UDS"->0.8257, "EUR"->0.6272, "JPY"->1.0, "CHF"->1.018),
    "CHF" -> Map("UDS"->0.8108, "EUR"->0.6160, "JPY"->0.982, "CHF"->1.0)
  )
}
