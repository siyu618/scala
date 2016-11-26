package week08

object test {
  println("Welcome to the scala worksheet")
  val f : String => String = {case "ping" => "pong"}
  f("ping")
  f("pong")
}


