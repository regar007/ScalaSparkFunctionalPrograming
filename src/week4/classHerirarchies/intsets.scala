package week4.classHerirarchies

object intsets extends App{
  val s1 = new nonEmpty(3, new Empty, new Empty)
  val s2 = s1 incl 4
  val s3 = s2 incl 1
  val s4 = s3 incl 2
  
  println(s1 +", "+ s2+", "+ s3 +", "+ s4 )
}