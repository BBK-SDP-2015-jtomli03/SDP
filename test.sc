
val x = Map(1 -> 2, 2 -> 3, 3 -> 4)
def returnSome(k: Int, v:Int) = Some(v)
x map (e => returnSome(e._1, e._2)) // [Some[Int]] = List(Some(2), Some(3), Some(4))
x flatMap (e => returnSome(e._1, e._2))  //[Int] = List(2, 3, 4)
def returnSomeTuple(k:Int, v:Int) = if (v > 2) Some(k->v) else None
x map (e => returnSomeTuple(e._1, e._2)) // [Option[(Int, Int)]] = List(None, Some((2,3)), Some((3,4)))
x flatMap (e => returnSomeTuple(e._1, e._2)) // Map[Int,Int] = Map(2 -> 3, 3 -> 4)
//Using a function block and case statement instead
x flatMap {case (k, v) => returnSomeTuple(k, v)} // Map[Int,Int] = Map(2 -> 3, 3 -> 4)
//using filter
//ie if the tuple (k,v) doesn't equal None,
//then the tuple from the original map is filtered through
//ie NOT the result of the function -> the code block is just
//a test that returns a boolean true (to filter through)
//and false (to discard)
x filter {case (k, v) => returnSomeTuple(k, v) != None} // Map[Int,Int] = Map(2 -> 3, 3 -> 4)
val one = List(1,2,3,4)
val two = List(1,2,3,4,5)
val zippedList = one zip two //res6: List[(Int, Int)] = List((1,1), (2,2), (3,3), (4,4))
zippedList flatMap {case (e1, e2) => List(e1, e2)} //List[Int] = List(1, 1, 2, 2, 3, 3, 4, 4)
one map (e => e * e) //List[Int] = List(1, 4, 9, 16) <-- note this is a new List, ie NOT List "one" still
val y = Map(10 -> 11, 12-> 13)
val zippedMap = x zip y // Map[(Int, Int),(Int, Int)] = Map((1,2) -> (10,11), (2,3) -> (12,13))
zippedMap.unzip //Iterable[(Int, Int)]) = (List((1,2), (2,3)),List((10,11), (12,13))) ie TWO LISTS
//flatten a List of Lists
val anotherList = List(List(1), List(3,4))
anotherList.flatten

//Concatenate Lists
one ++ two //List[Int] = List(1, 2, 3, 4, 1, 2, 3, 4, 5)

//Concatenate Maps
x ++ y // Map[Int,Int] = Map(10 -> 11, 1 -> 2, 2 -> 3, 12 -> 13, 3 -> 4)

//add an element to a List
0 :: one //List[Int] = List(0, 1, 2, 3, 4)
//add an element to a Map
//NOTE CAN ONLY ADD TO A MAP IF IT IS A VAR
// -> if z is a val it won't work cos can't reassign to a val
var z = Map(1 -> 2, 2 -> 3, 3 -> 4)
z += (99 -> 100)

val some = z get 2 // returns Some(3)
val none = z get 5 //returns None
val getMeTheVal = some get //returns Int = 2
//var getMeNone = none get // NoSuchElementException
var getMeNone = none.getOrElse("There is nothing!!") //Any = There is nothing!!

val obs = List(1,2,3,4,5,6,7,8,9)



