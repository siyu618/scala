

def whileLoop(condition: => Boolean)(command: => Unit): Unit = {
  if (condition) {
    command
    whileLoop(condition)(command)
  }
  else ()
}

// repeatLoop{command}{condition}
def repeatLoop(command: => Unit)(condition: => Boolean): Unit = {
  command
  if (condition) {
    repeatLoop(command)(condition)
  }
  else ()
}

// repeatLoopUntil {command} until (condition)
def repeatLoopUntil(command: => Unit)(condition: => Boolean): Unit = {
  command
  if (condition) {

  }
  else {
    repeatLoop(command)(condition)
  }
}