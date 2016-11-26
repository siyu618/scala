package porp.ch4

/**
 * Created by tianyuzhi on 16/10/6.
 */
class Consolidator(observed:List[BankAccount]) extends Subscriber {
  observed.foreach(_.subscribe(this))

  private var total : Int = _
  compute()

  private def compute() =
    total = observed.map(_.currentBalance).sum

  def handler(pub:Publisher) = compute()

  def totalBalance = total

}
