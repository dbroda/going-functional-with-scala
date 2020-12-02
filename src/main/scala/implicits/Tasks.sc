/**
  * Implement an implicit class that takes an int value `i` and has `fuckYeah` method that prints "fuckYeah" i times.
  */

//implicit class TaskToBeImplicit(value: Int) {
//  def fuckYeah(): Unit = {
//    for(_ <- 0 until value) println("fuckYeah")
//  }
//}

//5.fuckYeah()
/**
  * Use your previous implicit class and change it. Your new implicit class should:
  * - have fuckYeah method
  * - times method that takes a function parameter Int => Unit
  */

implicit class NewTask(value: Int) {
  def fuckYeah: Unit = times(_ => println("fuckYeah"))

  private def times(f: Int => Unit) = {
    for (i <- 0 until value) f(i)
  }
}


5.fuckYeah
