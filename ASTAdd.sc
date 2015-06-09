sealed trait Node
final case class Num(n: Int) extends Node
final case class Add(l: Node, r: Node) extends Node
final case class Minus(l: Node, r: Node) extends Node
final case class Mult(l: Node, r: Node) extends Node

val mytree = Minus(Mult(Add(Num(4),Num(3)), Num(2)), Add(Num(1),Mult(Num(5), Num(6))))

def printTree(tree: Node): String = tree match{
  case Num(num) => num.toString
  case Add(l,r) => "(" + printTree(l) + "+" + printTree(r) ")"
  case Minus(l, r) => "(" + printTree(l) + "-" + printTree(r) ")"
  case Mult(l, r) => "(" + printTree(l) + "*" + printTree(r) ")"
}

val x = printTree(mytree)

def evaluate(tree: Node): Int = tree match {
  case Num(x) => x
  case Add(l,r) =>  evaluate(l) + evaluate(r)
  case Minus(l, r) => evaluate(l) - evaluate(r)
  case Mult(l, r) => evaluate(l) * evaluate(r)
}
evaluate(mytree)





