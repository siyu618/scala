package my.study.scala.ch30_akka

import akka.actor._
/**
 * Created by tianyuzhi on 16/9/30.
 */

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage


class Ping(pong:ActorRef) extends Actor{
  var count = 0
  def incrementAndPrint: Unit = {
    count += 1
    println("ping " + count)
  }

  def receive = {
    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage
    case PongMessage =>
      if (count > 9) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      }
      else {
        incrementAndPrint
        sender ! PingMessage
      }
  }
}

class Pong extends Actor {
  def receive = {
    case PingMessage =>
      println(" ==ping")
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
      context.system.terminate
  }
}

object PingPong extends App {
  val system = ActorSystem("PingPongSystem")
  val pong = system.actorOf(Props[Pong], name = "pong")
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")
  ping ! StartMessage
}
