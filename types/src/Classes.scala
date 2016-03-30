/**
  * Created by Andra on 3/28/2016.
  */
object Classes {

  /**
    * A class for container types, which are able to enumerate their elements
      using a Haskell list. What is the kind of 'c'?
    */
  trait Container[C[_]]{
    def contents[A](a: C[A]): List[A]
  }

  /**
    * A class for types with invertible values. What is the kind of 'a'?
      The default invert operation is the identity.
    */
  trait Invertible[A] {
    def invert: A => A = identity
  }

  object Invertible {
    implicit object InvertibleChar extends Invertible[Char] {
      override def invert = identity
    }

    implicit object InvertibleInt extends Invertible[Int] {
      override def invert = identity
    }

    implicit object InvertibleBool extends Invertible[Boolean] {
      override def invert = identity
    }
  }
}
