package paths
package high

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._

import mid.Polygon
import misc.Linear


@js.native
trait StockOpts[A] extends js.Object {
  val data: js.Array[js.Array[A]] = js.native
  val xaccessor: js.Function1[A, Double] = js.native
  val yaccessor: js.Function1[A, Double] = js.native
  val width: Int = js.native
  val height: Int = js.native
  val closed: Boolean = js.native
}

object StockOpts {
  def apply[A](data: js.Array[js.Array[A]], xaccessor: js.Function1[A, Double],
      yaccessor: js.Function1[A, Double], width: Int, height: Int,
      closed: Boolean = false): StockOpts[A] =
    js.Dynamic.literal(
      data = data,
      xaccessor = xaccessor,
      yaccessor = yaccessor,
      width = width,
      height = height,
      closed = closed
    ).asInstanceOf[StockOpts[A]]
}

@js.native
@JSName("Paths.Stock")
object StockNative extends js.Object {
  def apply[A](options: StockOpts[A]): Stock[A] = js.native
}

@js.native
trait StockCurve[A] extends js.Object {
  val line: Polygon = js.native
  val area: Polygon = js.native
  val item: js.Array[A] = js.native
  val index: Int = js.native
}

@js.native
trait Stock[A] extends js.Object {
  val curves: js.Array[StockCurve[A]] = js.native
  val xscale: Linear = js.native
  val yscale: Linear = js.native
}

object Stock {
  def apply[A](data: Seq[Seq[A]], xaccessor: A => Double, yaccessor: A => Double,
    width: Int, height: Int, closed: Boolean = false) = {
    val d = data.toJSArray.map(_.toJSArray)
    StockNative(StockOpts(d, xaccessor, yaccessor, width, height, closed))
  }
}
