//Qu 3 - Animal Factory
sealed trait Animal
final case class Cat() extends Animal
final case class Dog() extends Animal

object AnimalFactory{
  def createAnimal(animal: String): Animal = animal match {
    case "cat" => new Cat
    case "dog" => new Dog
    case _ => throw new Error("We only make cats and dogs")
  }
}