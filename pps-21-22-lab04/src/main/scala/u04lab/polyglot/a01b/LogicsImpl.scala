package u04lab.polyglot.a01b
import scala.jdk.javaapi.OptionConverters
import u04lab.polyglot.OptionToOptional
import u04lab.code.Option
import u04lab.code.Option.*
import u04lab.code.List
import u04lab.code.List.*

/** solution and descriptions at https://bitbucket.org/mviroli/oop2019-esami/src/master/a01b/sol2/ */
class LogicsImpl(private val size: Int, private val mines: Int) extends Logics:
  
  private var camp: List[Tuple2[Int, Option[Int]]] = Nil()
  
  def hit(x: Int, y: Int): java.util.Optional[Integer] = camp match
    case Nil() => fillCamp(x, y)
    case _ => getElement(x, y)

  def won = false

  private def fillCamp(x: Int, y: Int): java.util.Optional[Integer] =
    fillWithZero()
    insertMines()
    getElement(x, y)

  private def fillWithZero(): Unit =
    (0 to size-1).foreach(_x =>
      (0 to size-1).foreach(_y =>
        camp = Cons(Tuple2(size * _x + _y, Some(0)), camp)
      )
    )

  private def insertMines(x: Int, y: Int): Unit =
    while sum(map(camp)(a => a._2 case None() => 1)):
      camp = map(camp)(a => a._1 match
        case pos if pos != (size * x + y) =>
      )

  private def getElement(x: Int, y: Int) = drop(camp, x * size + y) match
    case Cons(h, t) => OptionToOptional(h._2)
