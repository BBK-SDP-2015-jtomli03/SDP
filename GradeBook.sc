trait Tree
case class Num(x: Int) extends Tree
case class Sum(l: Tree, r: Tree) extends Tree


val sum = Sum(Sum(Num(1), Num(2)), Num(3))

