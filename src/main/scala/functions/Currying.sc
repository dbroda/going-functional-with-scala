def add(x: Int, y: Int) = x + y

def plus(x: Int)(y: Int) = x + y

val addXY = (x: Int, y: Int) => x + y

val addFunction = add _

val addCurried = addFunction.curried

addCurried(1)(2)

//Pass a block of code