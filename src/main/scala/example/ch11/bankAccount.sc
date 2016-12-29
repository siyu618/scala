class BankAccount {
  private var balance = 0
  def deposit(amount: Int): Unit = {
    if (amount > 0) balance += amount
  }
  def withdraw(amount: Int): Int =
    if (0 < amount && amount <= balance) {
      balance -= amount
      balance
    }
    else {
      sys.error("insufficient funds")
    }
}

val myAccount = new BankAccount

myAccount deposit 50

myAccount withdraw 20

myAccount withdraw 20

myAccount withdraw 15


