package u03

object TailLists extends App:

  // A generic linkedlist
  enum List[E]:
    case Cons(head: E, tail: List[E])
    case Nil()

  import u02.Optionals.Option.*;
  import u02.Optionals.Option;
  import annotation.tailrec;

  // a companion object (i.e., module) for List
  object List:

    def sum(l: List[Int]): Int =
      @tailrec
      def _sum(count: Int, l: List[Int]): Int = l match
        case Cons(h, t) => _sum(h + count, t)
        case _ => count

      _sum(0, l)

    def map[A, B](l: List[A])(mapper: A => B): List[B] = flatMap(l)(a => Cons(mapper(a), Nil()))

    def filter[A](l1: List[A])(pred: A => Boolean): List[A] = flatMap(l1)(a => a match
      case a if pred(a) => Cons(a, Nil())
      case _ => Nil()
    )

    @tailrec
    def drop[A](l: List[A], n: Int): List[A] = l match
      case Cons(h, t) if n > 1 => drop(t, n - 1)
      case Cons(h, t) => t
      case _ => Nil()

    def append[A](l: List[A], t: List[A]): List[A] =
      @tailrec
      def _append[A](acc: List[A], l: List[A], t: List[A]): List[A] = (l, t) match
        case (Cons(lh, lt), t) => _append(Cons(lh, acc), lt, t)
        case (l, Cons(rh, rt)) => _append(Cons(rh, acc), rt, Nil())
        case _ => acc

      _append(Nil(), l, t)

    def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = l match
      case Cons(h, t) => append(f(h), flatMap(t)(f))
      case _ => Nil()

    def max(l: List[Int]): Option[Int] =
      @tailrec
      def _max(curMax: Option[Int], l: List[Int]): Option[Int] = l match
        case Cons(h, t) if h >= orElse(curMax, h) => _max(Some(h), t)
        case Cons(h, t) => _max(curMax, t)
        case _ => curMax

      _max(None(), l)

    @tailrec
    def foldLeft[A, B](li: List[A])(init: B)(f: (B, A) => B): B = li match
      case Cons(h, t) => foldLeft(t)(f(init, h))(f)
      case _ =>  init

    def foldRight[A, B](li: List[A])(init: B)(f: (A, B) => B): B = li match
      case Cons(h, t) if t == Nil() => f(h, init)
      case Cons(h, t) => f(h, foldRight(t)(init)(f))

  val l = List.Cons(10, List.Cons(20, List.Cons(30, List.Nil())))
  println(List.sum(l)) // 60

  import List.*

  println(sum(map(filter(l)(_ >= 20))(_ + 1))) // 21+31 = 52
