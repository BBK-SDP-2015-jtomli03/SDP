//partially applied functions are functions defined from other functions but
// with some of the arguments bound, leaving the rest to add later
// ie we can bind one parameter, and leave the other parameter unbound
// by putting an underscore in its place

def method(s1: String, num: Int) = {
  print(s1 + "; " + num)
}

def partiallyAppliedMethod = method("Number is", _: Int)

val partial = partiallyAppliedMethod(3)
