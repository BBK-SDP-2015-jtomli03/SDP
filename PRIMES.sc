import scala.annotation.tailrec

//returns the prime factors of a specified Int
def getPrimeFactors(n: Int): List[Int] = {
  @tailrec
  def rec(i: Int, num: Int, acc: List[Int]): List[Int] = {
    (i until num).find {
      num % _ == 0
    }match{
      case None => num :: acc
      case Some(x) => rec(i , num / x, x :: acc)
    }
  }
  rec(2, n, List())
}
getPrimeFactors(47)

//checks if a number is prime
def isPrime(num: Int):Boolean = {
  (2 until num) find{
    num % _ == 0
  }match{
    case None => true
    case Some(x) => false
  }
}
isPrime(600)

//returns a list of all the prime numbers in the input list
def getPrimes(list: List[Int]): List[Int] = {
  list filter (isPrime(_))
}
getPrimes(List(1,2,3,4,5,6,7,8,9,10))

//returns a list of all the prime numbers in the input list + 2
def addTwoToPrimes(list: List[Int]): List[Int] = {
  list filter (isPrime(_)) map (_ + 2)
}
addTwoToPrimes(List(1,2,3,4,5,6,7,8,9,10))