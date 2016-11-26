package porp.ch4

/**
 * Created by tianyuzhi on 16/10/6.
 */
trait Subscriber {
  def handler(pub: Publisher)

}
