object Optionals extends App:
  enum Option[A]:
    case Some(a: A)
    case None() // here parens are needed because of genericity.
  
  object Option:
    def isEmpty[A](opt: Option[A]): Boolean = opt match
      case None() => true
      case _ => false
    def orElse[A, B >: A](opt: Option[A], orElse: B): B = opt match
      case Some(a) => a
      case _ => orElse
    def flatMap[A, B](opt: Option[A])(f: A => Option[B]): Option[B] = opt match
      case Some(a) => f(a)
      case _ => None()
    def filter[A](opt: Option[A])(f: A => Boolean): Option[A] = opt match
      case Some(a) if f(a) => Some(a)
      case _ => None()
    def map[A](opt: Option[A])(f: A => Boolean): Option[Boolean] = opt match
      case Some(a) => Some(f(a))
      case _ => None()
    def map2[A](opt1: Option[A])(opt2: Option[A])(f: (A, A) => A): Option[A] = (opt1, opt2) match
      case (Some(a1), Some(a2)) => Some(f(a1, a2))
      case _ => None()

  import Option.*
  val s5: Option[Int] = Some(5)
  val sN: Option[Int] = None()
  val s8: Option[Int] = Some(8)

  println(filter(s5)(_ > 2)) // Some(5)
  println(filter(s5)(_ > 8)) // None()
  println(filter(sN)(_ > 2)) // None()
  println(map(s5)(_ > 2)) // Some(true)
  println(map(s5)(_ > 8)) // Some(false)
  println(map(sN)(_ > 2)) // None()
  println(map2(s5)(sN)(_ + _)) // None()
  println(map2(s5)(s8)(_ + _)) // Some(13)
  println(map2(s8)(s5)(_ - _)) // Some(3)
