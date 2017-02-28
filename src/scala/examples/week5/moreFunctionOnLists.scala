package week5

import scala.tools.nsc.transform.Flatten
import org.apache.hadoop.fs.shell.Tail

object moreFunctionOnLists extends App {
  val fruit = List("apple", "orange", "pears")
  val num = List(1,2,3)
  val diag = List(List(1,0,0), List(0,1,0), List(0,0,1))
  val empty = List()
  
  def removeAt(n: Int, xs: List[Int]) = (xs take n) ::: (xs drop n+1)
  
  def flatten(xs: List[Any]) : List[Any] = xs match {
    case List() => xs
    case y :: ys => y :: flatten(List(y).tail) ++ flatten(ys)
  }
  val flattenList = flatten(diag)
  print(flattenList)
}