package u04lab.code

case class StudentImpl(name: String, year: Int) extends Student:
  import List.*
  private var coursesList: List[Course] = Nil()
  override def enrolling(courses: Course*): Unit = courses.foreach(course => coursesList = Cons(course, coursesList))
  override def courses: List[String] = map[Course, String](coursesList)(course => course.name)
  override def hasTeacher(teacher: String): Boolean =
    contains[String](map[Course, String](coursesList)(course => course.teacher), teacher)
