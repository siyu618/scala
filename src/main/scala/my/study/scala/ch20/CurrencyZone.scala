package my.study.scala.ch20

/**
 * Created by tianyuzhi on 16/9/27.
 */
abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(x:Long) : Currency

  abstract class AbstractCurrency {
    val amount: Long
    def designation: String

    def + (that:Currency) : Currency = make(this.amount + that.amount)
    def * (x : Double) : Currency = make((this.amount * x).toLong)
    def - (that: Currency) : Currency = make(this.amount - that.amount)
    def / (x:Double) : Currency = make((this.amount/x).toLong)
    def / (that:Currency) = this.amount.toDouble / that.amount.toDouble

    def from(other:CurrencyZone#AbstractCurrency) : Currency = {
      make(Math.round(other.amount.toDouble
        * Converter.exchangeRate(other.designation)(this.designation)))
    }

    private def decimals(n:Long) : Int =
      if (n == 1) 0 else 1 + decimals(n/10)

    override def toString =
      (amount.toDouble/CurrencyUnit.amount.toDouble) .formatted ("%." + decimals(CurrencyUnit.amount) + "f")
  }
  val CurrencyUnit : Currency
}
object US extends CurrencyZone  {
  abstract class Dollar extends AbstractCurrency {
    def designation = "USD"
  }

  type Currency = Dollar
  def make(cents:Long) = new Dollar {
    override val amount: Long = cents
  }

  val Cent = make(1)
  val Dollar = make( 100)
  val CurrencyUnit = Dollar

}

object Europe extends CurrencyZone {
  abstract class Euro extends AbstractCurrency {
    def designation = "EUR"
  }
  type Currency = Euro
  def make(cents :Long)  = new Euro {
    override val amount: Long = cents
  }

  val Cent = make(1)
  val Euro = make(100)
  val CurrencyUnit = Euro
}

object Japan extends CurrencyZone {
  abstract class Yen extends AbstractCurrency {
    def designation = "JPY"
  }
  type Currency = Yen
  def make(yen:Long) = new Yen {
    override val amount: Long = yen
  }

  val Yen = make(1)
  val CurrencyUnit = Yen
}

object Test extends App {
  Japan.Yen from US.Dollar * 100

}