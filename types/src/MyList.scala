import Classes.{Invertible, Container}

/**
  * Created by Andra on 3/28/2016.
  */

/**
  * Instantiate the following classes with the Haskell list type:
  * 'Container'
  * 'Invertible'

    The inversion should be performed DEEPLY i.e., for the elements as well.
  */
object MyList {
  implicit object ContainerList extends Container[List] {
    def contents[A](a: List[A]) = identity(a)
  }
  implicit object InvertibleList extends Invertible[List[_]] {
    def invert[A] = (list: List[A]) => list.reverse
  }
}
