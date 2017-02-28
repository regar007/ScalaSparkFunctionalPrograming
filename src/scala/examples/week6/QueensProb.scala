package week6

object QueensProb extends App{
  def queens(n : Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if(k == 0) Set(List())
      else
       for{
        queens <- placeQueens(k - 1)
        col <- 0 until n
        if isSafe(col, queens)
       } yield col :: queens
    }
    placeQueens(n)
  }
  
  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val queensWithRow = (row -1 to 0 by -1) zip queens  //combination with previous queens with all rows
    queensWithRow forall {
      case (r,c) => col != c && math.abs(col - c) != row - r
    }
  }
  
  def show(queens: List[Int]) = {
    val (lines) = 
      for (col <- queens.reverse)
        yield (Vector.fill(queens.length)("* ").updated(col, "X ").mkString)
        ("\n") + (lines mkString "\n")   
  }
  
  
 // println(queens(5))
  println((queens(8) map show) mkString "\n")
}