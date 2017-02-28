package week6

object map extends App{
  val romanNumerals = Map('I' ->(1), 'V' -> 5)
  val capitals = Map("India" -> "Delhi", "Rajasthan" -> "Jaipur")
  
  def showCapitals(country: String) = capitals.get(country) match {
    case Some(capital) => capital
    case None => "missing data"
  }
  
  println(capitals("India"))
//  println(capitals("Tamilnadu")) //raise error
  println(capitals get ("Tamilnadu"))
  println(showCapitals("Tamilnadu"))
}