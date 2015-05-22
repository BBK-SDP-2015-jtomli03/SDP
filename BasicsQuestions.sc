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
def general(f: Int => Int, combine: (Int, Int) => Int, startNum: Int)(a: Int, b: Int): Int = {
  def iter(a:Int, startNum: Int): Int = {
    if(a > b) startNum
    else (a to b).map(f).reduce(combine)
  }
  iter(a, startNum)
}

