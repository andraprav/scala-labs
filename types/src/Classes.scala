/**
  * Created by Andra on 3/28/2016.
  */
object Classes {

  /**
    * A class for container types, which are able to enumerate their elements
      using a Haskell list. What is the kind of 'c'?
    */
  trait Container[C[_]]{
    def contents[A](a: C[A] ): List[A]
  }

  /**
    * A class for types with invertible values. What is the kind of 'a'?
      The default invert operation is the identity.
    */
  trait Invertible[A] {
    def invert (a: A): A = identity(a)
  }
}
