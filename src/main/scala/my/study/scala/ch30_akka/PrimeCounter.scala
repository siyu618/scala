package my.study.scala.ch30_akka

import akka.actor.{ActorRef, Props, ActorSystem, Actor}

/**
 * Created by tianyuzhi on 16/9/30.
 */

case object STOP

case object NO_MORE_NUMBERS

case object I_AM_DONE

case object GIVE_ME_A_NEW_ONE


class Assembler extends Actor {
  var primeNumCount = 0


  def receive = {
    case count: Int =>
      primeNumCount += count
      println("current primeNumCount is " + primeNumCount)
    case STOP =>
      println("total primeNumCount is " + primeNumCount)
      context.system.terminate()
  }

}

class Dispatcher(maxNum: Int, actorCount: Int, assembler: ActorRef) extends Actor {
  var curNum = 2
  var actors = actorCount


  def receive = {
    case GIVE_ME_A_NEW_ONE =>
      if (curNum <= maxNum) {
        println("dispatcher give:" + curNum)
        sender ! curNum
        curNum = curNum + 1
      }
      else {
        sender ! NO_MORE_NUMBERS
      }
    case I_AM_DONE =>
      actors = actors - 1
      if (actors == 0) {
        assembler ! STOP
      }
  }

}

class Processor(dispatcher: ActorRef, assembler: ActorRef) extends Actor {
  var primeNumCount = 0

  override def preStart = {
    dispatcher ! GIVE_ME_A_NEW_ONE
  }

  def receive = {
    case NO_MORE_NUMBERS =>
      assembler ! primeNumCount
      sender ! I_AM_DONE
      context.system.terminate()
    case num: Int =>
      if (isPrime(num)) {
        primeNumCount = primeNumCount + 1
      }
      sender ! GIVE_ME_A_NEW_ONE
  }

  def isPrime(num: Int): Boolean = {
    for (i <- 2 to num - 1) {
      if (num % i == 0) {
        return false
      }
    }
    true
  }
}

object PrimeCounter extends App {
  val system = ActorSystem("PrimeCounter")
  val assembler = system.actorOf(Props[Assembler], name = "assembler")
  val dispatcher = system.actorOf(Props(new Dispatcher(100, 10, assembler)), "dispatcher")
  for (i <- 0 to 9) {
    val processor = system.actorOf(Props(new Processor(dispatcher, assembler) ))
  }

}
