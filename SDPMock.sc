import scala.annotation.tailrec

//Qu 3 - Animal Factory
sealed trait Animal
private case class Cat() extends Animal
private case class Dog() extends Animal

object Animal{
  def apply(animal: String): Animal = animal match {
    case "cat" => new Cat
    case "dog" => new Dog
    case _ => throw new Error("We only make cats and dogs")
  }
}

//Qu 4 - Mergesort - merge function - recursive and tail recursive
//The cmp function takes two arguments and returns true if the first
//argument is less than or equal to the second argument.
def merge[T](as: List[T], bs: List[T])(cmp: (T, T) => Boolean): List[T] = (as, bs) match {
  case (Nil, bs) => bs
  case (as, Nil) => as
  case(ashd::astail, bshd::bstail) => if (cmp(ashd, bshd)) ashd :: merge(astail, bs)(cmp)
                                      else bshd :: merge(as, bstail)(cmp)
}

def merge2[T](as: List[T], bs: List[T])(cmp: (T, T) => Boolean): List[T] = {
  @tailrec
  def mergeHelper(acc: List[T], as: List[T], bs: List[T]): List[T] = (as, bs) match {
    case (Nil, bs) => bs ++ acc
    case (as, Nil) => as ++ acc
    case(ashd::astail, bshd::bstail) => if (cmp(ashd, bshd)) mergeHelper(ashd :: acc, astail, bs)
                                        else mergeHelper(bshd :: acc, as, bstail)
  }
  mergeHelper(List(), as, bs).reverse
}

merge2(List(1,4,7,10,11), List(2,3,5,7,12,16))((x,y) => x <= y)

//Question 5
def iterate[T](x: T)(f: T => T): Stream[T] = {
  x #:: iterate(f(x))(f)
}

//Question 6
//Multiset returns 0 for any Int not in the Multiset
//and the number of times it appears otherwise
type MultiSet = Int => Int

def emptyMultiSet: MultiSet = x => 0
def singleton(x: Int): MultiSet = y => if(y == x) 1 else 0

def union(a: MultiSet, b: MultiSet): MultiSet = {
  x => a(x) + b(x)
}
def min(a: Int,b: Int): Int = a min b

def intersect(a: MultiSet, b: MultiSet): MultiSet = {
  //y => min(a(y), b(y))
  y => a(y) min b(y)
}

def diff(a: MultiSet, b: MultiSet): MultiSet = {
  y => (a(y) - b(y)) max 0
}

def primeFactors(n: Int): MultiSet = {
  def returnMultiSet(start: Int, num: Int): MultiSet = {
    (start until num).find{
      num % _ == 0
    }match{
      case None => singleton(num)
      case Some(x) => union(singleton(x), returnMultiSet(start, num/x))
    }
  }
  returnMultiSet(2, n)
}



































