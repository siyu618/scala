//package my.study.scala.ch30
//
//import scala.actors.Actor
//
///**
// * Created by tianyuzhi on 16/9/30.
// */
//
//trait Simulant extends Actor
//class Wire extends Simulant
//
//case class Ping(time:Int)
//case class Pong(time:Int, from:Actor)
//case class WorkItem(time:Int, msg:Any, target:Actor)
//case class AfterDelay(delay:Int, msg:Any, target:Actor)
//case object Start
//case object Stop
//
//class Clock extends Actor {
//  private var running = false
//  private var currentTime = 0
//  private var agenda : List[WorkItem] = List()
//  private var allSimulants:List[Actor] = List()
//  private var busySimulants:Set[Actor] = Set.empty
//
//}
