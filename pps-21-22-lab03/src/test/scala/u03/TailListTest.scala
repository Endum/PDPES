package u03

import org.junit.*
import org.junit.Assert.*
import TailLists.*
import u02.Optionals.Option.*;
import u02.Optionals.Option;

class TailListTest:

  import List.*

  val l: List[Int] = Cons(10, Cons(20, Cons(30, Nil())))
  val lst = Cons(10, Cons(20, Cons(30, Nil())))
  val tail = Cons(40, Nil())
  val lstFold = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))

  @Test def testSum() =
    assertEquals(0, sum(Nil()))
    assertEquals(60, sum(l))

  @Test def testMap() =
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), map(l)(_ + 1))
    assertEquals(Cons("10", Cons("20", Cons("30", Nil()))), map(l)(_ + ""))

  @Test def testFilter() =
    assertEquals(Cons(20, Cons(30, Nil())), filter(l)(_ >= 20))
    assertEquals(Cons(10, Cons(30, Nil())), filter(l)(_ != 20))

  @Test def testDrop() =
    assertEquals(Cons(20, Cons(30, Nil())), drop(lst, 1))
    assertEquals(Cons(30, Nil()), drop(lst, 2))
    assertEquals(Nil(), drop(lst, 5))

  @Test def testAppend() =
    assertEquals(Cons(10, Cons(20, Cons(30, Cons(40, Cons(40, Nil()))))), append(lst, append(tail, tail))) //

  @Test def testFlatMap() =
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), flatMap(lst)(v => Cons(v + 1, Nil())))
    assertEquals(Cons(11, Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, Nil())))))), flatMap(lst)(v => Cons(v + 1, Cons(v + 2, Nil()))))

  @Test def testMax() =
    assertEquals(Some(25), max(Cons(10, Cons(25, Cons(20, Nil())))))
    assertEquals(None(), max(Nil()))

  @Test def testFold() =
    assertEquals(-16, foldLeft(lstFold)(0)(_ - _))
    assertEquals(-8, foldRight(lstFold)(0)(_ - _))
