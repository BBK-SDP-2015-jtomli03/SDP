sealed trait Tree
final case class Operator(f: String, args: List[Tree]) extends Tree
final case class Terminal(n: Int) extends Tree

val tree = Operator("+", List(Operator("-", List(Terminal(5), Terminal(4))),Terminal(5), Terminal(6)))

def printT(t: Tree): String = t match {
  case Terminal(n) => n.toString
  case Operator(f, args) => "(" + f + "," + mks(args, ",") + ")"
}

def mks(args: List[Tree], sep: String): String = args match {
  case Nil => ""
  case hd :: Nil => printT(hd)
  case hd :: tail => printT(hd) + sep + mks(tail, sep)
}
printT(tree)

val tree2 = Operator("+", List(Operator("-", List(Terminal(5), Terminal(4))),Terminal(5), Terminal(6)))

def evalT(t: Tree): Int = t match{
  case Terminal(n) => n
  case Operator(f, args) => f match{
    case "+" => (args map (x => evalT(x))) reduceLeft(_ + _)
    case "-" => (args map (x => evalT(x))) reduceLeft(_ - _)
    case "*" => (args map (x => evalT(x))) reduceLeft(_ * _)
  }
}

evalT(tree2)
