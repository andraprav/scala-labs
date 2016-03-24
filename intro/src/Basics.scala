/**
  * Created by Andra on 3/20/2016.
  */
object Basics {


  /**
    1. (1p)
    Implement the 'reverse' function, which returns a given list
    in reverse order, using explicit recursion.
    Do NOT employ any higher-order functions.
   */

  def reverseRec1[T](a:List[T]): List[T] = a match {
    case Nil => Nil
    case (h::t) => reverseRec1(t) :+ h
  }

  /**
    2. (1p)
    Same as (1), but change the direction on which the output is built.
    For example, if (1) built the list on return from recursion,
    you should now built the list when recursing forward.
   */
  def reverseRec2Aux[T](a: List[T], returnValue: List[T]): List[T] = a match {
    case Nil    => returnValue
    case (h::t) => reverseRec2Aux(t, h::returnValue)
  }

  def reverseRec2[T](a: List[T]): List[T] = reverseRec2Aux(a, Nil)

  /**
    3. (1.5p)
    Same as (1), but use a higher-order function instead.
    Do NOT employ explicit recursion.
    Make sure that your solution faithfully reflects the process from (1).
    */

  def reverseRec3[T] = (list: List[T]) => list.foldRight(List[T]()){(x: T, acum: List[T]) => acum :+ x}

  /**
    * Same as (2), but use a higher-order function instead.
    Do NOT employ explicit recursion.
    Make sure that your solution faithfully reflects the process from (2).
    */

  def reverseRec4[T] = (list: List[T]) => list.foldLeft(List[T]()){(acum: List[T], x: T) => x :: acum }

  /**
    * {-
    5. (1p)
    Implement the power set function, which returns the set of all subsets
    of a set, using explicit recursion.
    -}

    powerSetRec :: [a] -> [[a]]
    powerSetRec = undefined
    */

  def concatElemToList[A](x: A, list: List[A]): List[Any] = (x,list) match {
    case (x, Nil)     =>
      List(List(x))
    case (x, ((h:List[_]) :: t)) =>
      (x :: h) :: (concatElemToList(x, t))
    case (x, (h::t))  =>
      List(x, h) :: (concatElemToList(x, t))
  }
  
  def powerSetRec[A] (a: List[A]): List[Any] = a match {
    case Nil    =>
      List( )
    case (h::t) =>
      powerSetRec(t) ++ concatElemToList(h, powerSetRec (t))
  }

  /**
    * 6. (1.5p)
    Same as (5), but use higher-order functions instead.
    Do NOT employ explicit recursion.
    Make sure that your solution faithfully reflects the process from (5).
    */


}

object Main extends App {
  import Basics._

  println(reverseRec1(List(1, 2, 3, 4, 5)))
  println(reverseRec2(List("a", "n", "d", "r", "a")))
  println(reverseRec3(List(List(1, 2, 3), List("a", "b", "c"))))
  println(reverseRec3(List(List(1, 2, 3), List("a", "b", "c"))))

  println(powerSetRec(List("a", "b", "c")))
}