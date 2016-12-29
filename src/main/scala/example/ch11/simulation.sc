//
//
//type Action = () => Unit
//
//
//
//
//abstract class Simulation {
//  case class WorkItem(time: Int, action: Action)
//  private type Agenda = List[WorkItem]
//  private var agenda: Agenda = List()
//
//  def currentTime: Int
//  def afterDelay(delay:Int, action: => Action)
//  def run()
//}
//
//class Wire {
//  private var sigVal = false
//  private var actions: List[Action] = List()
//  def getSignal = sigVal
//  def setSignal(s: Boolean): Boolean = {
//    if (s != sigVal) {
//      sigVal = s
//      actions.foreach(action => action())
//    }
//  }
//  def addAction(a: Action): Unit = {
//    actions = a :: actions()
//    a()
//  }
//}
//
//def invert(input: Wire, output: Wire): Unit = {
//  def invertAction(): Unit = {
//    val inputSig = input.getSignal
//    afterDe
//  }
//}