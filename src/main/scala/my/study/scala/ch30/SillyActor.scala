package my.study.scala.ch30

import java.net.{InetAddress, UnknownHostException}

import scala.actors._

/**
 * Created by tianyuzhi on 16/9/30.
 */
object SillyActor extends Actor {
  def act(): Unit = {
    for (i <- 1 to 5) {
      println("I'm acting")
      Thread.sleep(1000)
    }
  }
}

object SeriousActor extends Actor {
  def act() = {
    for (i <- 1 to 5) {
      println("this is the question")
      Thread.sleep(1000)
    }
  }
}

object NameResolver extends Actor {

  def act() {
    react {
      case (name: String, actor: Actor) =>
        actor ! getIp(name)
        act()
      case "EXIT" =>
        println("Name resolver exiting.")
      case msg =>
        println("Unhandled message:" + msg)
        act()
    }
  }

  def getIp(name: String): Option[InetAddress] = {
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _: UnknownHostException => None
    }
  }
}
//
//object ActorTest {
//  def main(args: Array[String]) {
//    val sillyActor2 = Actor {
//      def emoteLater() = {
//        val mainActor = self
//        Actor {
//          Thread.sleep(1000)
//          mainActor ! "Emote"
//
//        }
//      }
//
//      var emoted = 0
//      emoteLater()
//
//      loop {
//        react {
//          case "Emote" =>
//            println("I'm acting!")
//            emoted += 1
//            if (emoted < 5)
//              emoteLater()
//          case msg =>
//            println("Received: " + msg)
//        }
//      }
//    }
//  }
//}