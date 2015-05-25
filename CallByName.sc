
def getString() ={
  println("This is the String")
  "x"
}
//call by value evaluates the values of the parameters before
// they are passed to the function
def CBV(str: String): String = {
  println("In CBV......")
  str
}

//call by name doesn't evaluate the values of the parameters
// until they are required
def CBN(str: => String): String = {
  println("In CBN......")
  println("The string is; " + str)
  println("end")
  str
}

// prints "This is the string"; "In CBV";
CBV(getString())
// prints "In CBN"; "This is the string"; "The String is x"; "end"; "This is the string";
CBN(getString())

