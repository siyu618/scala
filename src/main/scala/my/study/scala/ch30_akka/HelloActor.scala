package my.study.scala.ch30_akka

import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

/**
 * Created by tianyuzhi on 16/9/30.
 */
class HelloActor extends Actor{
  def receive = {
    case "Hello" => println("Hello!")
    case _ => println("Who are you?")
  }
}

object HelloActor extends App {
  val system = ActorSystem("HelloSystem")
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  helloActor ! "Hello"
  helloActor ! "hi"
}
