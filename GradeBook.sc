import scala.collection.Map

type CourseWork = (String, Int) //String = comments, Int = grade
//use sequence here, not List, cos Seq is an interface, so more options than a concrete class such as List
type Portfolio = Seq[CourseWork] //Seq((String, Int),(String, Int))
type Results = Seq[Portfolio] // Seq(Seq((String, Int),(String, Int)),Seq((String, Int),(String, Int)))
//Mapped Version
type MappedCourseWork = Map[Int,(String, Int)] //has a coursework number associated with each cw
type MappedPortfolio = Seq[MappedCourseWork]
type MappedResults = Seq[MappedPortfolio]
case class Student(id: Int, results: Results)
case class MappedStudent(id: Int, results: MappedResults)

val student = Student(1, Seq(Seq(("good", 65),("excel", 90)),Seq(("poor", 45),("average", 100))))

def topGrade(results: Results): Int = results match {
  case Nil => 0
  case hd :: Nil => getResults(hd)
  case hd :: tail => if(getResults(hd) > topGrade(tail)) getResults(hd) else topGrade(tail)
}

def getResults(portfolio: Portfolio): Int = {
  portfolio map(e => e._2) reduceLeft(_ max _)
}
topGrade(student.results)

def averageGrade(results: Results): Double = results match {
  case Nil => 0
  case hd :: Nil => getAverage(hd)
  case hd :: tail => (getAverage(hd) + averageGrade(tail)) / 2
}

def getAverage(portfolio: Portfolio): Double = {
  val total = portfolio map (e => e._2) reduceLeft(_ + _)
  total / portfolio.length
}
averageGrade(student.results)

val mappedCWCS = Map(1 -> ("good", 65), 2 -> ("excel", 90))
val mappedCWFOC = Map(3 -> ("good", 65), 4 -> ("excel", 90))
val myPortfolio = Seq(mappedCWCS, mappedCWFOC)
val myResults = Seq(myPortfolio)
val moi = MappedStudent(2, myResults)

val mappedStudent = MappedStudent(1, Seq(Seq(Map(1 -> ("good", 65), 2 -> ("excel", 90))),Seq(Map(3 -> ("poor", 45)), Map(4-> ("average", 15)))))

def topGradeMappedCoursework(results: MappedResults): Int = results match {
  case Nil => sys.error("No Results")
  case hd :: Nil => getGrades(hd) //head = Seq(Map(1 -> ("good", 65), 2 -> ("excel", 90))
  case hd :: tail => List(getGrades(hd), topGradeMappedCoursework(tail)).reduceLeft(_ max _)
}

def getGrades(grades: Seq[MappedCourseWork]): Int = grades match {
  case hd :: Nil => getValue(hd) //ie a single map
  case hd :: tail => List(getValue(hd), getGrades(tail)).reduceLeft(_ max _)
}

//takes a single map
def getValue(resultMap: Map[Int,(String, Int)]): Int = {
  resultMap map (e => e._2) map (e => e._2) reduceLeft(_ max _)
}

topGradeMappedCoursework(mappedStudent.results)
