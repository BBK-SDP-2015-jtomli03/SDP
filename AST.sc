//sealed traits
//final case classes
sealed trait Tree
final case class Operator(f: String, args: List[Tree]) extends Tree
final case class Terminal(n: Int) extends Tree

val tree = Operator("+", List(Operator("-", List(Terminal(3), Terminal(4))),Terminal(5), Terminal(6)))

def printTree(t: Tree): String = t match{
  case Terminal(x) => x.toString
  case Operator(f, args) => "(" + f + "," + mks(args, ",") + ")"
}

def mks(ls: List[Tree], sep: String): String = ls match {
  case Nil => ""
  case hd :: Nil => printTree(hd)
  case hd :: tail => printTree(hd) + sep + mks(tail, sep)
}
printTree(tree)

def printTreeInfix(tree: Tree): String = tree match {
  case Terminal(x) => x.toString
  case Operator(f, args) => "(" + mksInfix(f, args) + ")"
}

def mksInfix(f: String, args: List[Tree]): String = args match {
  case Nil=> ""
  case hd :: Nil => printTreeInfix(hd)
  case hd :: tail => printTreeInfix(hd) + f + mksInfix(f, tail)
}
printTreeInfix(tree)







