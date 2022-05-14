package u05lab.ex1

import org.junit.{Before, Test}
import org.junit.Assert.*

class ListTest:

  @Before
  val reference = List(1, 2, 3, 4)

  @Test
  def testZipRight(): Unit =
    assertEquals(List((1, 0), (2, 1), (3, 2), (4, 3)), reference.zipRight)

  @Test
  def testPartition(): Unit =
    assertEquals((List(2, 4), List(1, 3)), reference.partition(_ % 2 == 0))

  @Test
  def testSpan(): Unit =
    assertEquals((List(1), List(2, 3, 4)), reference.span(_ % 2 != 0))
    assertEquals((List(1, 2), List(3, 4)), reference.span(_ < 3))

  @Test
  def testReduce(): Unit =
    assertEquals(10, reference.reduce(_ + _))
    assertThrows(classOf[UnsupportedOperationException], () => Nil.reduce((a,b) => a))
    assertEquals(10, List(10).reduce(_ + _))

  @Test
  def testTakeRight(): Unit =
    assertEquals(List(2, 3, 4), reference.takeRight(3))

  @Test
  def testCollect(): Unit =
    assertEquals(List("2", "6"), reference.collect(new PartialFunction[Int, String]{
      def apply(x: Int) = (x * 2).toString
      def isDefinedAt(x: Int) = x % 2 == 1
    }))
