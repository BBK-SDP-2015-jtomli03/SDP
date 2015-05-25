val ls = List(1,2,3,4)
val hello = List('h', 'e', 'l', 'l', 'o')

//filter Chars
def filterChar(char: Char): List[Char] => List[Char] = {
  def filterThisChar(ls: List[Char]): List[Char] = ls match {
    case Nil => Nil
    case hd :: tail => if(hd == char) hd :: filterThisChar(tail)
                      else filterThisChar(tail)
  }
  filterThisChar
}

//currying
filterChar('l')(hello)
//filter all L's function
def filterL = filterChar('l')
filterL(List('h', 'e', 'l', 'l', 'o'))

//applies a function to the integers between a and b, and sums them
def sum(f: Int => Int)(a: Int, b: Int): Int =
  if(a>b) 0 else f(a) + sum(f)(a+1, b)

//cubes the integer parameters
def cubed = sum((i: Int) => i * i * i )
cubed(1, 10)





