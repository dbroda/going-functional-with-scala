import scala.language.higherKinds

/**
  * Create a new similar to Maybe[A]. Call it Or[A, B]
  * It should be similar to Either[A, B]
  * Implement both map and flatMap methods
  */
//
//trait Or[A, B] {
//  def map[C](f: A => C): Or[A,C] = {
//
//    def ac[C](value: A)(f: A => C): Or[A,C] = {
//      Left(f)
//    }
//
//    this match {
//      case Right(x) => Right(f(x))
//      case Left(x) => Left(f(x))
//    }
//  }
//
//  def flatMap[C](f: A => Or[A, C]): Or[A, C] = ???
//}
//
//case class Right[A, B](right: B) extends Or[A, B]
//case class Left[A, B](left: A) extends Or[A, B]

/**
We all know that every monad is also a Functor.
  Using methods pure() and flatMap() try to implement map method.

  */

trait Monad[F[_]] {
  def pure[A](value: A): F[A]

  def flatMap[A, B](value: A)(f: A => F[B]): F[B]

  def map[A, B](value: F[A])(f: A => B): F[B] = ???
}

object MonadTasks extends App {
  //here test your code

}