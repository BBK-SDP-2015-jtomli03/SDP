
//REDUCE
//reduceLeft works from L -> R starting with the first element in the
//collection, and using each result as an input for the next
def sum(ls: List[Int]): Int = (0::ls) reduceLeft (_ + _)

//this looks neater but will result in an error if applied to an empty List
def sumWrong(ls: List[Int]): Int = ls reduceLeft (_ + _)

//product
def product(ls: List[Int]): Int = ls reduceLeft (_ * _)

//note -> in the real world we can just use sum
List(2, 10, 3, 8, 22).sum

//get max and min values from a list
List(2, 10, 3, 8, 22).max //returns Int = 22
List(2, 10, 3, 8, 22).min  //returns Int = 2

//find the max value with reduceLeft
List(2, 10, 3, 8, 22) reduceLeft (_ max _) //returns Int = 22

//use a function
def maximum = (x: Int, y: Int) => x max y
List(2, 10, 3, 8, 22) reduceLeft (maximum)

//max/min works with chars
List('a', 'b', 'c', 'd').max  //returns Char = d

//can call like this
val list = List('a', 'b', 'c', 'd')
list.max

//use reduceLeft to find the shortest string
def shortest = (s1: String, s2: String) => if(s1.length < s2.length) s1 else s2
List("a", "short", "list", "of", "strings") reduceLeft (shortest)

//factorial using reduceLeft
def factorial(num: Int): Int = (1 to num) reduceLeft (_ * _)

//print results
def printReduceLeftAddition = (x: Int, y: Int) => {
  println(x + "+" + y)
  x + y
}

//FOLD
//fold can take data in one format and return it in another
//fold takes two arguments -> a start value, and a function
//the function also takes two arguments -> an ACCUMULATOR,
//and the current item in the list
//NOTE: HAVE TO USE .fold
val one = List(2, 10, 3, 8, 22)

//so we can sum integers
one.foldLeft(0)((acc, nextNum) => acc + nextNum)
//or more simply
one.foldLeft(0)(_ + _)

//using a function
def sumIt = (a: Int, b: Int) => a + b
one.fold(0)(sumIt)

//but can also do things like take a List[Int] and change it to a List[String]
one.foldLeft(List[String]()){(a, b) => a :+ "a" + b} //returns List[String] = List(a2, a10, a3, a8, a22)

//or change a List to a Map, mapping the String to its length
def change = (acc: Map[String, Int], b: String) => acc + (b -> b.length)
List("a", "short", "list", "of", "strings").foldLeft(Map[String, Int]()){change} //returns Map[String,Int] = Map(short -> 5, a -> 1, strings -> 7, of -> 2, list -> 4)













