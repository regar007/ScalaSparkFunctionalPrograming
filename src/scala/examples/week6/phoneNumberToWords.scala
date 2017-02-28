package week6

import scala.io.Source

object phoneNumberToWords extends App{
  //val in = Source.fromURI("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords")
  val mnemonics = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
  
  val words = Source.fromString("ashok\nR\nRegar\nis\nthe\nKing\nScala\nis\nfun\n").getLines.toList filter (word => word forall (chr => chr.isLetter))  //invert the mnem map to give a map from chars 'A' ... 'Z' to '2' ... '9'
  val charCode: Map[Char, Char] = for(
    (digit, str) <- mnemonics; Itr <- str    
  ) yield Itr -> digit 
  
  // Map a word to the digit string it can represent, e.g., "Java" -> "5282"
  def wordCode(word: String): String = 
    word.toUpperCase() map charCode 
  
  //A map from digit string to the words that represent them, "5282" -> List("Java", "Kata", "Lata", ...) 
  val wordsForNum: Map[String, Seq[String]] = 
    words groupBy wordCode withDefaultValue Seq()
    
  //Return all way to encode a number as a list of words  
  def encode(number: String): Set[List[String]] =
    if(number.isEmpty()) Set(List())
    else {
      for {
        split <- 1 to number.length
        word <- wordsForNum(number take split)
        rest <- encode(number drop split)        
      } yield word :: rest
    }.toSet
    
  def translate(number: String): Set[String] = 
    encode(number) map (_ mkString " ")
    
  println(charCode+ "\n"+ words)
  println(wordCode("Java"))
  println(wordsForNum)
  println(encode("7225247386"))
  println(translate("7225247386"))
}