package paths
package high

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._

import low.Path
import mid.SemiRegularPolygon


trait RadarOpts[A] extends js.Object {
  val data: js.Array[A] = js.native
  val accessor: Map[String, js.Function1[A, Double]] = js.native
  val max: js.UndefOr[Double] = js.native
  val center: Point = js.native
  val r: Double = js.native
  val rings: Int = js.native
}

object RadarOpts {
  def apply[A](data: js.Array[A], accessor: js.Dictionary[js.Function1[A, Double]],
      max: js.UndefOr[Double], center: Point, r: Double, rings: Int = 3): RadarOpts[A] =
    js.Dynamic.literal(
      data = data,
      accessor = accessor,
      max = max,
      center = center,
      r = r,
      rings = rings
    ).asInstanceOf[RadarOpts[A]]
}

@JSName("paths.Radar")
object RadarNative extends js.Object {
  def apply[A](options: RadarOpts[A]): Radar[A] = js.native
}

trait RadarCurve[A] extends js.Object {
  val polygon: SemiRegularPolygon = js.native
  val item: A = js.native
  val index: Int = js.native
}

trait Radar[A] extends js.Object {
  val curves: js.Array[RadarCurve[A]] = js.native
  val rings: js.Array[Path] = js.native
}

object Radar {
  def apply[A](data: Seq[A], accessor: Map[String, A => Double], max: Option[Double] = None,
    center: (Double, Double), r: Double, rings: Int) = {
    // val d = data.toJSArray.asInstanceOf[js.Array[Any]]
    // val acc = accessor mapValues { f => (x: Any) => f(x.asInstanceOf[A]) }
    val acc: Map[String, js.Function1[A, Double]] = accessor mapValues { x => x }
    val (x, y) = center
    RadarNative(RadarOpts(data.toJSArray, acc.toJSDictionary, max.orUndefined, js.Array(x, y), r, rings))
  }
}