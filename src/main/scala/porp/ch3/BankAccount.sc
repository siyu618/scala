/**
 * an objcet has a state if its behavior is influenced by its history.
 */


class BankAccount {
  /**
   * stateful class
   */
  private var balance = 0

  def deposit(amount: Int): Unit = {
    if (amount > 0) balance = balance + amount
  }

  def withdraw(amount: Int): Int = {
    if (0 < amount && amount <= balance) {
      balance = balance - amount
      balance
    }
    else {
      throw new Error("insufficient funds")
    }
  }
}

println("account")
val account = new BankAccount
account deposit  50
account withdraw 20
account withdraw 20
account withdraw 15





