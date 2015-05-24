sealed trait Node
final case class Num(n: Int) extends Node
final case class Add(l: Node, r: Node) extends Node
final case class Minus(l: Node, r: Node) extends Node
final case class Mult(l: Node, r: Node) extends Node

val tree = Minus(Mult(Add(Num(4),Num(3)), Num(2)), Add(Num(1),Add(Num(5), Num(6))))

def evaluate(node: Node): Int = node match {
  case Num(x) => x
  case Add(l, r) => evaluate(l) + evaluate(r)
  case Minus(l, r) => evaluate(l) - evaluate(r)
  case Mult(l, r) => evaluate(l) * evaluate(r)
}
evaluate(tree)

def printTree(node: Node): String = node match {
  case Num(x) => x.toString
  case Add(l , r) => "(" + printTree(l) + " + " + printTree(r) + ")"
  case Minus(l, r) => "(" + printTree(l) + " - " + printTree(r) + ")"
  case Mult(l, r) => "(" + printTree(l) + " * " + printTree(r) + ")"
}
printTree(tree)
