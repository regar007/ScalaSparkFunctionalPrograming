package week4.typesAndPatternMatching

trait Expr {
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
}

//
//object Number[T] extends T{
//  def toInt = new Number(T).toInt
//  
//}
//
//object expr{
//  def show(e : Expr): String = e match {
//    case Number(x) => x.toString
//    case Sum(l,r) => show(l) + " + "+ show(r)
//  }
//  
//  show(Sum(NUmber(1), Number(2)))
//}