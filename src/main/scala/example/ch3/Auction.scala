/*
package example.ch3

import java.util.Date
import java.util.concurrent.TimeUnit

import akka.actor._
import akka.util.Timeout
import scala.concurrent.duration._
import scala.util.Random

/**
 * Created by tianyuzhi on 16/11/25.
 */
abstract class AuctionMessage
case class Offer(bid:Int, client: ActorRef) extends AuctionMessage
case class Inquire(client: Actor) extends AuctionMessage

abstract class AuctionReply
case class Status(asked:Int, expire:Date) extends AuctionReply
case object BestOffer extends AuctionReply
case class BeatenOffer(maxBid:Int) extends AuctionReply
case class AuctionConcluded(seller:ActorRef, client:ActorRef) extends AuctionReply
case object AuctionFailed extends AuctionReply
case object AuctionOver extends AuctionReply

class  Auction(seller:ActorRef, minBid:Int, closing:Date) extends Actor {
  val timeToShutdown = 36000000// msec
  val bidIncrement = 10
  var maxBid = minBid - bidIncrement
  var maxBidder: ActorRef = null

  def preStart(): Unit = {
  }

  context.setReceiveTimeout(Duration.create(closing.getTime() - new Date().getTime(), TimeUnit.MILLISECONDS))
  def receive = {
    case Offer(bid, client) =>
      if (bid >= maxBid + bidIncrement) {
        if (maxBid >= minBid) maxBidder ! BeatenOffer(bid)
        maxBid = bid
        maxBidder = client
        client ! BeatenOffer(maxBid)
      }
    case Inquire(client) =>
      client ! Status(maxBid, closing)
    case ReceiveTimeout =>
      if (maxBid >= minBid) {
        val reply = AuctionConcluded(seller, maxBidder)
        maxBidder ! reply
        seller ! reply
      }
      else {
        seller ! AuctionFailed
      }
      context.setReceiveTimeout(Duration.create(timeToShutdown,TimeUnit.MILLISECONDS))
//      receive = {
//        case Offer(_, client) => client ! AuctionOver
//        case ReceiveTimeout => context.stop(self)
//      }
  }
}

class Seller extends Actor
class Client(i:Int, increment:Int, top:Int, auction: Auction) extends Actor with ActorLogging {
  val name = "Client " + i
  var max: Int = _
  var current : Int = 0
  log.info("start")
  auction ! Inquire(this)

  def receive = {
    case Status(maxBid, _) =>
      log.info("status(" + maxBid + ")")
      max = maxBid
      if (max >= top) {
        log.info("too high for me")
      }
      else if (current < max) {
        current = max + increment
        Thread.sleep(1 + Random.nextInt(1000))
        auction ! Offer(current, this)
      }
    case BestOffer =>
      log.info("best offer(" + current + ")")
    case BeatenOffer(maxBid) =>
      log.info("beatenOffer(" + maxBid + ")")
      max = maxBid
      if (max >= top) {
        log.info("too high for me")
      }
      else if (current < max) {
        current = max + increment
        Thread.sleep(1 + Random.nextInt(1000))
        auction ! Offer(current, this)
      }
    case AuctionConcluded(seller, maxBidder) =>
      log.info("auctionConcluded")
      context stop self
    case AuctionOver =>
      log.info("auction over")
      context stop self
    case ReceiveTimeout =>
      context stop self

  }


}

object Auction extends App {
  val random = new Random()
  val minBid = 100
  val closing = new Date(new Date().getTime() + 4000)

  implicit val system = ActorSystem()
  val seller = system.actorOf(Props(new Seller()), "seller")
  val auction = system.actorOf(Props(new Auction(seller, minBid, closing)), "auction")
  val client1 = system.actorOf(Props(new Client(1, 20, 200, auction), "client1"))
  val client2 = system.actorOf(Props(new Client(2, 10, 300, auction), "client1"))
  val client3 = system.actorOf(Props(new Client(3, 15, 300, auction), "client1"))
  val client4 = system.actorOf(Props(new Client(4, 50, 500, auction), "client1"))

}

*/
