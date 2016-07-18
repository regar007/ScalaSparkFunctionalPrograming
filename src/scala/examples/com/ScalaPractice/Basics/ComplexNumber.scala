package com.ScalaPractice.Basics;
import myPackages.Complex
import myPackages.Constants
import myPackages.Const
import myPackages.Var
import myPackages.Sum

object ComplexNumber {

  type Environment = String => Int

  def main(arg : Array[String]){
    val _complex = new Complex(1.3,1.5)
    val _const = Const(10)
    val _var = Var("1")
    val _sum = Sum(Const(1),Const(5))
    println("Imaginary number is : "+ eval(_sum, {case "x" => 4}))
  }
  
  def eval(t: Constants, env : Environment): Int = t match{
    case Sum(l,r) => eval(l, env)+ eval(r, env)
    case Var(n) => env(n)
    case Const(v) => v
  }
}
