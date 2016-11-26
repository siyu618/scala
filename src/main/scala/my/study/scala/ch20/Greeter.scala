package my.study.scala.ch20

/**
 * Created by tianyuzhi on 16/9/28.
 */
class PreferredPrompt(val preference:String)
class PreferredDrink(val preference:String)

object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master> ")
  implicit val drink = new PreferredDrink("tea")
}
object Greeter {
  def greet(name:String)(implicit prompt:PreferredPrompt, drink:PreferredDrink) {
    println("Welcome, " + name + ". The system is ready.")
    print("But while you work, " )
    println("why not enjoy a cup of " + drink.preference + "?")
    println(prompt.preference)
  }

  def main (args: Array[String]) {
    import JoesPrefs._
    Greeter.greet("Joe")

  }
}