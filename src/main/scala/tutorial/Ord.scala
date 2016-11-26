package tutorial


/**
 * Created by tianyuzhi on 16/10/8.
 */
trait Ord {
  def < (that:Any): Boolean
  def <=(that:Any): Boolean = (this < that)  || this == that
  def > (that:Any): Boolean = !(this <= that)
  def >=(that:Any): Boolean = !(this < that)
}

class Date(y:Int, m:Int, d:Int) extends Ord {
  def year = y
  def month = m
  def day = d

  override def toString = year + "-" + month + "-" + day

  override def equals(that: Any): Boolean =
    that.isInstanceOf[Date]  && {
      val o = that.asInstanceOf[Date]
      o.day == day && o.month == month && o.day == day
    }
  override def hashCode = ((41 + year) * 41 + month) * 41 + day

  def <(that:Any):Boolean = {
    if (!that.isInstanceOf[Date])
      sys.error("cannot compare " + that + " and a date")
    val o = that.asInstanceOf[Date]
    (year < o.year) ||
      (year == o.year) && (month < o.month ||
        month == o.month && day < o.day
        )
  }
}
