package typeclassses

import typeclassses.adapter.HtmlWriter

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}
import scala.text.DocGroup

case class Person(name: String, email: String)


trait Equal[A] {
  def equal(v1: A, v2: A): Boolean
}

object Person {

  def apply[A](implicit equal: Equal[A]): Equal[A] = equal

  /**
    * Implement implicit objects for comparing Person data. Wrap it in another singleton object.
    */
  implicit object EmailEqual extends Equal[Person] {

    override def equal(v1: Person, v2: Person): Boolean =
      v1.email == v2.email
  }

  implicit class PersonImplicit(p: Person) {

    def equalsByMail(p2: Person)(implicit equalHolder: Equal[Person]) = {
      equalHolder.equal(p, p2)
    }
  }

}

object ByNames {

  implicit object ByNameEqual extends Equal[Person] {
    override def equal(v1: Person, v2: Person): Boolean =
      v1.name == v2.name
  }

}

/**
  * Implement Companion Object with an apply method.
  * The method takes two parameters of A and an implicit Equal[A]
  */

object EqualsTask extends App {
  //check your solution here
  private val person: Person = Person("a", "a@gmail.com")
  private val person2: Person = Person("a", "b@gmail.com")
  //
  //  private val value: Equal[Person] = EmailEquals[Person]
  //  println(value.equal(person, person2))

  import ByNames._

  println(person.equalsByMail(person2))

  val animal = new Animal()

  val dog = new Animal() with Dog
  val cat = new Animal() with Cat

  val anotherCat: Animal with Dog = dog
}

class Animal {
}

trait Dog

trait Cat


/**
  * Implement Companion Object with an apply method.
  * The method take only implicit Equal[A]
  */

object ImplicitEqualsTask extends App {
  //check your solution here
}


trait Monad[F[_]] {
  def lift[A](value: A): F[A]

  def flatMap[A, B](value: F[A])(f: A => F[B]): F[B]

  def map[A, B](value: F[A])(f: A => B): F[B] = {
    flatMap(value) {
      v => lift(f(v))
    }
  }
}

  //case class FutureOptionT1[A](value: Future[Option[A]])(implicit ec: ExecutionContext) {
  //  def map[B](f: A => B): FutureOptionT[B] = FutureOptionT(value.map(_.map(f)))
  //  def flatMap[B](f: A => FutureOptionT[B]): FutureOptionT[B] = FutureOptionT(value.flatMap {
  //    case Some(a) => f(a).value
  //    case None => Future.successful(None)
  //  })
  //}

case class ListOptionT[A](value: List[Option[A]])(implicit ec: ExecutionContext) {
  def map[B](f: A => B): ListOptionT[B] = ListOptionT(value.map(_.map(f)))
  def flatMap[B](f: A => ListOptionT[B]): ListOptionT[B] = ListOptionT(value.flatMap {
    case Some(a) => f(a).value
    case None => None
  })
}


case class OptionT[A, F[_]](value: F[Option[A]]) {
  def map[B](f: A => B)(implicit fa: Monad[F]): OptionT[B, F] = OptionT(fa.map(value)( _.map(f)))
  def flatMap[B](f: A => OptionT[B, F])(implicit fa: Monad[F]): OptionT[B, F] = OptionT(fa.flatMap(value) {
    case Some(a) => f(a).value
    case None => fa.lift(None)
  })
}

  object abc {
    val x = OptionT(Future {
      Some(1)
    })
  }


