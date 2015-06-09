type Player = (String, String, Int)
type Squad = Seq[Player] //no of players
type Division = Seq[Squad] //no of squads

val p1 = ("t", "bob", 40)
val p2 = ("b", "mike", 30)
val p3 = ("m", "gaz", 20)
val p4 = ("m", "gaz", 20)
val p5 = ("m", "gaz", 20)
val p6 = ("m", "gaz", 20)
val squad = Seq(p1, p2, p3, p4, p5, p6)

def averageAge(sq: Squad): Double = sq match {
  case Nil => 0
  case hd :: Nil => hd._3
  case hd :: tail => (hd._3 + sum(tail)) / sq.length
}

def sum(sq: Squad): Double = sq match {
  case Nil => 0
  case hd :: Nil => hd._3
  case hd :: tail => hd._3 + sum(tail)
}

def partitionAges(sq: Squad):(Squad, Squad) = sq match {
  case Nil => (Nil, Nil)
  case hd :: Nil => sys.error("only one player")
  case hd :: tail => sq partition {isBelowAvg(_, sq)}
}

def isBelowAvg(player: Player, sq: Squad): Boolean = {
  player._3 < averageAge(sq)
}

def mapPlayersAges(sq: Squad): Map[Int, Int] = sq match {
  case Nil => sys.error("noone in squad")
  case hd :: Nil => Map(hd._3 -> 1)
  case hd :: tail => partitionSameAges(sq map(e => e._3))
}

def partitionSameAges(ls: Seq[Int]): Map[Int, Int] = ls match {
  case Nil => Map()
  case hd :: tail => {
    val (age, next) = ls partition(_ == hd)
    Map(age.head -> age.length) ++ partitionSameAges(next)
  }
}

averageAge(squad)
partitionAges(squad)
mapPlayersAges(squad)

//def listToSet(ls: List[Int]): Set[Int] = ls match{
//  case Nil => Set()
//  case hd::Nil => Set(hd)
//  case hd :: tail => ls filter (inList(_, ls))
//}
//
//def inList(num: Int, ls: List[Int]): Boolean = {
//
//}






