import scala.math._

//question 3 PRACTICE PAPER
def estimateB(a: Double, bMin: Double, bMax: Double, err: Double) : Double = {
  val estimate = (bMin + bMax) / 2
  val x = (a + estimate) / a
  val y = a/ estimate
  val difference = abs(x - y)
  if (difference < err) estimate
  else if (x > y) estimateB(a, bMin, estimate, err)
  else estimateB(a, estimate, bMax, err)
}

//question 7 a)
def lsort[T](list: List[List[T]]): List[List[T]] =
  list sortWith (_.length < _.length)

//question 7 b)
object WellSorted {
  def lsortFreq[T](list: List[List[T]]): List[List[T]] = {
    //create a list of the lengths of each list in the list-to-sort and order from lowest to highest length
    val lengths = list.map(_.length) .sortWith(_ < _)
    //sortLengths creates a List-A of List-B's....Each List-B contains all instances of a certain length, eg List(1,1,1)
    val sortedLengths = sortLengths(lengths)
    //creates a List of the length of each List-B in sortedLengths (this length = the frequency of each length in the list-to-sort)
    val frequencies = sortedLengths map (_.length)
    //creates a list of just the heads of each List-B in sortedLengths (ie. the set of lengths of the individual Lists in list-to-sort)
    val listOfLengths = sortedLengths.map { case (hd :: tail) => hd }
    //creates a Map of (key = length, value = frequency)
    val mapped = (listOfLengths zip frequencies).toMap
    //sort the list-to-sort according to the frequency of the length of each List
    list sortWith {
      (l1: List[T], l2: List[T]) => mapped.apply(l1.length) < mapped.apply(l2.length)
    }
  }

  def sortLengths[T](ls: List[T]): List[List[T]] = ls match {
    case Nil => Nil
    case hd :: tail => {
      val (first, next) = ls partition (_ == hd)
      first :: sortLengths(next)
    }
  }
}

val list = List(List(), List(2,3), List(4), List(6,7,8), List(8,9,9), List(1,2,4))
//val list = List(1,1,1,2,2,3,3,3)

//Question 8 -> PIE AND MASH
case class Pie(kind: String)
val pieKinds = List("Stewed Eels", "Jellied Eels", "only beef", "no mash")
//mapping pie kind => no in a packet
val pieNumbers: String => Int = { x => x match{
  case "Stewed Eels" => 1
  case "Jellied Eels" => 2
  case "only beef" => 1
  case "no mash" => 3
}

//  8a)
//  def oneOf[T](ls: List[T]): Generator[T] = choose(0, ls.length - 1).map(e => ls(e))
//
//  val pieGen: Generator[Pie] = oneOf(pieKinds).map(string => new Pie(string))
//
//  8b)
//  val piesByKind: Observable[(String, Observable[Pie])] = pieChannel.groupBy(_.kind)

//    8.c)
//    val pieBoxed: Observable[Observable[Box]] = {
//      piesByKind.map((pieType, obs) => obs.buffer(pieNumbers(pieType)))
//    }
//
//    8.d) type Box = Seq[Pie] and type Packet = Seq[Box]
//    val piePackets: Observable[Packet] = Observable.zip(pieBoxed)

}













































