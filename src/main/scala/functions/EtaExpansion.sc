val addOne = (x: Int) => x + 1

val addTwo = new Function1[Int, Int] {
  def apply(v1: Int): Int = v1 + 2
}

addOne(1)

def add(x: Int, y: Int) = x + y

val eta = add _ //eta-expansion

eta.isInstanceOf[Function2[_, _, _]]

/**
  * The technique of converting a def method into a function
  * uses Eta-Expansion
  * Ok, so now we have a true function (Int, Int) => Int
  * but we'd like to have (Int) => (Int) => Int
  */