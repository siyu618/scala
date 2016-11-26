/*
package my.study.scala.ch18

/**
 * Created by tianyuzhi on 16/9/26.
 */
object MySimulation extends CircuitSimulation{
  def InverterDelay = 1
  def AndGateDelay = 3
  def OrGateDelay = 5

  def main(args: Array[String]) {
    val input1, input2, sum, carry = new Wire
    probe("sum", sum)
    probe("carry", carry)
    halfAdder(input1, input2, sum, carry)
    input1 setSignal true
    run()
    input2 setSignal true
    run()
  }
}
*/
