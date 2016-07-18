package week4.classHerirarchies

abstract class IntSet {
  def incl (x: Int) : IntSet
  def contains(x: Int) :  Boolean
}

class Empty extends IntSet {
  def contains(x: Int) : Boolean = false
  def incl(x: Int) : IntSet = new nonEmpty(x, new Empty, new Empty)
  override def toString = "."
}

class nonEmpty(elem: Int, left: IntSet, right : IntSet) extends IntSet {
  def contains(x : Int): Boolean = {
    if(x < elem) left contains x
    else if(x > elem) right contains x
    else true
  }
  
  def incl(x: Int): IntSet = {
    if(x < elem) new nonEmpty(elem, left incl x, right)
    else if(x > elem) new nonEmpty(elem, left, right incl x)
    else this
  }

  override def toString = "{"+ left + elem + right + "}"

}