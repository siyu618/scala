package my.study.scala.ch20

/**
 * Created by tianyuzhi on 16/9/29.
 */
object Email {
  def apply(user:String, domain:String) = user + "@" + domain
  def unapply(str:String): Option[(String, String)] = {
    val parts = str  split "@"
    if (parts.length == 2) Some(parts(0), parts(1))
    else None
  }
}

object Twice {
  def apply(s:String) : String = s + s
  def unapply(s:String): Option[String] = {
    val len = s.length /2
    val half = s.substring(0, len)
    if (half == s.substring(len)) Some(half) else None
  }
}

object UpperCase {
  def unapply(s:String) : Boolean = s.toUpperCase() == s
}

object TestMail {
  def userTwiceUpper(s:String) = s match {
    case Email(Twice(x @ UpperCase()), domain) =>
      "match:" + x + " in domain " + domain
    case _ =>
      "no match"
  }

  def main(args: Array[String]) {
    println(userTwiceUpper("DIDI@hotmail.com"))
    println(userTwiceUpper("DIDO@hotmail.com"))
    println(userTwiceUpper("didi@hotmail.com"))
  }
}

object ExpandedEMail {
  def unapplySeq(email:String)
     : Option[(String, Seq[String])] = {
    val parts = email split "@"
    if (parts.length == 2)
       Some(parts(0), parts(1).split("\\.").reverse)
    else None
  }

  def main(args: Array[String]) {
    val s = "tom@support.epf1.ch"
    val ExpandedEMail(name, topdomain, subdomains @_*) = s
  }
}
