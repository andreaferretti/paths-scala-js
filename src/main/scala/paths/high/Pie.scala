package paths
package high

import scala.scalajs.js
import js.annotation.JSGlobal
import js.JSConverters._

import mid.Sector


@js.native
trait PieOpts[A] extends js.Object {
  val data: js.Array[A] = js.native
  val accessor: js.Function1[A, Double] = js.native
  val center: Point = js.native
  val r: Double = js.native
  val R: Double = js.native
}

object PieOpts {
  def apply[A](data: js.Array[A], accessor: js.Function1[A, Double],
      center: Point, r: Double, R: Double): PieOpts[A] =
    js.Dynamic.literal(
      data = data,
      accessor = accessor,
      center = center,
      r = r,
      R = R
    ).asInstanceOf[PieOpts[A]]
}

@js.native
@JSGlobal("Paths.Pie")
object PieNative extends js.Object {
  def apply[A](options: PieOpts[A]): Pie[A] = js.native
}

@js.native
trait PieCurve[A] extends js.Object {
  val sector: Sector = js.native
  val item: A = js.native
  val index: Int = js.native
}

@js.native
trait Pie[A] extends js.Object {
  val curves: js.Array[PieCurve[A]] = js.native
}

object Pie {
  def apply[A](data: Seq[A], accessor: A => Double, center: (Double, Double), r: Double, R: Double) = {
    val (x, y) = center
    PieNative(PieOpts(data.toJSArray, accessor, js.Array(x, y), r, R))
  }
}