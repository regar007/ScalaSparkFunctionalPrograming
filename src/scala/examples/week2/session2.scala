package week2

object session2 extends App {
  def fact(n : Int): Int = {
    def loop(acc : Int, n : Int): Int = 
      if (n == 0) acc
      else loop(acc * n, n-1)
     loop(1,n)
  }

  def pascalVal(i: Int, j: Int): Int =  fact(i)/(fact(j) * fact(i-j)) 
  
  def pascalTri(noOfLines : Int) = {
    for(i <- 0 to noOfLines-1){
      for(j <- 0 to noOfLines - i - 2) print(" ")
      for(j <- 0 to i) print(pascalVal(i, j)+ " ")
      print("\n")
    }
  }
  val res = fact(15)
  println(res)
    
  pascalTri(10)
}
