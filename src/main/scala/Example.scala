import scalaz._, Scalaz._
import effectful._

object Example extends App {
  val xs = List(1,2,3)
  val ys = List(true,false)

  val e1 = effectfully((xs!, ys!))
  val f1 = for (x <- xs; y <- ys) yield (x, y)

  assert(e1 == f1)

  assert(effectfully(42.some.! + 1) == 43.some)

  assert(effectfully(10.some.! + 5.some.! * 2.some.!) == 20.some)

  val f2 = effectfully(((_: Int) * 2).! + ((_: Int) + 10).!)

  assert(f2(1) == 13)

  // cannot use implicit conversion?
  //
  // val f3 = effectfully {
  //   val chars   = (s: String) => s.length
  //   val letters = (s: String) => s.count(_.isLetter)
  //   chars.! - letters.!
  // }
  //
  // assert(f3("R2-D2") == 3)
}
