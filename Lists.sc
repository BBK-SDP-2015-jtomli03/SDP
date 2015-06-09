val x = List(1,2,3,4,5)
val y = List(5,6,7,8)

x ++ y //List[Int] = List(1, 2, 3, 4, 5, 5, 6, 7, 8)
x :: y //List[Any] = List(List(1, 2, 3, 4, 5), 5, 6, 7, 8)
x :+ 3 //List[Int] = List(1, 2, 3, 4, 5, 3)
3 +: x //List[Int] = List(3, 1, 2, 3, 4, 5)
3 :: x //List[Int] = List(3, 1, 2, 3, 4, 5)
// ::: adds the elements of a given list in front of this list
x ::: y //List[Int] = List(1, 2, 3, 4, 5, 5, 6, 7, 8)

y ::: x

def addA = (acc: List[String], num: Int) => acc :+ "num" + num
x.foldLeft(List[String]()){addA}








