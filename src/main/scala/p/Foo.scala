package p

object Foo {

  case class Person(name: String, age: Int, hobbies: Option[String])
       
  val personInstance = Person("foo", 555, Some("things"))
  val personNoHobbies = Person("foo", 555, None)
  val PERSON_JSON = """ { "name": "Foo", "age": 555 } """
  
  def buildPersonWithoutHobbies(name: String, age: Int) =
    Person(name, age, None)

  def buildPersonWithHobbies(name: String, age: Int, hobbies: String) =
    Person(name, age, Some( hobbies ))
}