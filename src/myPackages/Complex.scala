package myPackages

class Complex(real : Double, imaginary : Double ) {
  def re = real
  def im() = imaginary 
  override def toString() = ""+ re +" , "+ im() 
}

abstract class Constants 
  case class Sum(l : Constants, r : Constants) extends Constants
  case class Var(n : String) extends Constants
  case class Const(v : Int) extends Constants

