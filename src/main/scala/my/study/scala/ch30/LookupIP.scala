package my.study.scala.ch30

import scala.actors.Actor
import scala.actors.Actor._
import java.net.{InetAddress, UnknownHostException}
/**
 * Created by tianyuzhi on 16/9/30.
 */
case class LookupIP (name:String, respondTo:Actor)
case class LookupResult(
                       name:String,
                       address:Option[InetAddress]
                         )

object NameResolver2 extends Actor {
  def act(): Unit = {
    loop {
      react {
        case LookupIP(name, actor) =>
          println("find")
          actor ! LookupResult(name, getIp(name))
        case LookupResult(name, someResult) =>
          println("SHow")
          println(name + " : " + someResult.get)
      }
    }
  }
  def getIp(name:String): Option[InetAddress] = {
    try {
      println("get by name : " + name)
      Some(InetAddress.getByName(name))
    } catch {
      case _: UnknownHostException => None
    }
  }
}
