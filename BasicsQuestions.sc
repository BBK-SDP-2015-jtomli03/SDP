import scala.annotation.tailrec

//qu.3
def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def iter(a:Int, result: Int): Int = {
    if(a > b) result
    else iter(a + 1, f(a) + result)
  }
  iter(a, 0)
}

//qu.4
def product(f: Int => Int)(a: Int, b: Int): Int = {
  def iter(a:Int, result: Int): Int = {
    if(a > b) result
    else iter(a + 1, f(a) * result)
  }
  iter(a, 1)
}

//qu.5
def factorial(num: Int): Int = {
  product(x => x)(1, num)
}

//qu.6
//combine = (x, y) => x * y, startNum = 1
//combine = (x, y) => x + y, startNum = 0
//tail recursive method
def generalTail(f: Int => Int)(combine: (Int, Int) => Int, result: Int)(a: Int, b: Int): Int = {
  @tailrec
  def iter(a:Int, result: Int): Int = {
    if(a > b) result
    else iter(a + 1, combine(result, f(a)))
  }
  iter(a, result)
}

//non-tail recursive
def general(f: Int => Int, combine: (Int, Int) => Int, result: Int)(a: Int, b: Int): Int = {
  def iter(a:Int, result: Int): Int = {
    if(a > b) result
    else combine(iter(a + 1, result), f(a))
  }
  iter(a, result)
}

//or more simply
def generalSimple(f: Int => Int, combine: (Int, Int) => Int)(a: Int, b: Int): Int = a match {
  case _ if(a > b) => 0
  case _ => (a to b).map(f).reduce(combine)
}
generalSimple((x) => x, (x, y) => x + y)(1,3)

//qu.7

trait IntSet{
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(set: IntSet): IntSet
  def intersection(set: IntSet): IntSet
  def isEmpty: Boolean
  def excl(x: Int): IntSet
}
case class EmptySet() extends IntSet{
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet =
    new NonEmptySet(x, new EmptySet, new EmptySet)

  override def isEmpty = true

  override def union(set: IntSet): IntSet = set

  override def intersection(set: IntSet): IntSet = this

  override def excl(x: Int): IntSet = this
}
case class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet{
  override def contains(x: Int): Boolean = {
    if (x < elem)left contains x
    else if (x > elem) right contains x
    else true
  }

  override def incl(x: Int): IntSet = {
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
  }

  override def isEmpty = false

  override def union(set: IntSet): IntSet = {
    val returnSet = left.union(right.union(set))
    returnSet.incl(elem)
  }

  override def intersection(set: IntSet): IntSet = {
    val l = left.intersection(set)
    val r = right.intersection(set)
    val returnSet = l.union(r)
    if (set.contains(elem)) returnSet.incl(elem) else returnSet
  }

  override def excl(x: Int): IntSet = {
    if (!contains(x)) this
    else if (x < elem) new NonEmptySet(elem, left excl(x), right)
    else if (x > elem) new NonEmptySet(elem, left, right excl(x))
    else left.union(right)
  }

}


























