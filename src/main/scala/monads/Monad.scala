package monads

trait Maybe[A] {
  def map[B](f: A => B): Maybe[B]= {
    this match {
      case Empty() => Empty()
      case Full(x) => Full(f(x))
    }
  }

  def flatMap[B](f: A => Maybe[B]): Maybe[B] = {
    this match {
      case Full(x) => f(x)
      case Empty() => Empty()
    }
  }
}

case class Full[A](value: A) extends Maybe[A]
case class Empty[A]() extends Maybe[A]

//object Monads extends App {
//
//  val maybe = Empty()
////    Full("softwaremill")
//
//  val strLength = for {
//    s <- maybe
//  } yield s.length
//
//  println(s"String length is: $strLength")
//}