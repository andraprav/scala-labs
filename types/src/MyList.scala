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
    //invert = reverse . map invert
    //def invert[A] = (list: List[A]) => (reverse list compose map invert)

    //def invert[A] = (list: List[A]) => list.reverse
    //def reverse[A](ls: List[A]) = ls reverse
    //override def invert[A]: List[A] => List[A] = list => list.reverse compose map invert _
//    override def invert[A]: List[A] => List[A] = list => list.map((a) => invert(a)).reverse
//     def invert(list: List[Any]): List[Any] = list.reverse.map((a) => invert(a))
     def invert[A](list: List[A])(implicit ev: Invertible[A] = null): List[A] = Option(ev).map(r => list map r.reverse).getOrElse(list).reverse

  }
}

object A {
}