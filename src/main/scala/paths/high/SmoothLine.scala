package paths
package high

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._

import mid.Shape
import misc.Linear


@js.native
trait SmoothLineOpts[A] extends js.Object {
  val data: js.Array[js.Array[A]] = js.native
  val xaccessor: js.Function1[A, Double] = js.native
  val yaccessor: js.Function1[A, Double] = js.native
  val width: Int = js.native
  val height: Int = js.native
  val closed: Boolean = js.native
}

object SmoothLineOpts {
  def apply[A](data: js.Array[js.Array[A]], xaccessor: js.Function1[A, Double],
      yaccessor: js.Function1[A, Double], width: Int, height: Int,
      closed: Boolean = false): SmoothLineOpts[A] =
    js.Dynamic.literal(
      data = data,
      xaccessor = xaccessor,
      yaccessor = yaccessor,
      width = width,
      height = height,
      closed = closed
    ).asInstanceOf[SmoothLineOpts[A]]
}

@js.native
@JSName("paths.SmoothLine")
object SmoothLineNative extends js.Object {
  def apply[A](options: SmoothLineOpts[A]): SmoothLine[A] = js.native
}

@js.native
trait SmoothLineCurve[A] extends js.Object {
  val line: Shape = js.native
  val area: Shape = js.native
  val item: js.Array[A] = js.native
  val index: Int = js.native
}

@js.native
trait SmoothLine[A] extends js.Object {
  val curves: js.Array[SmoothLineCurve[A]] = js.native
  val xscale: Linear = js.native
  val yscale: Linear = js.native
}

object SmoothLine {
  def apply[A](data: Seq[Seq[A]], xaccessor: A => Double, yaccessor: A => Double,
    width: Int, height: Int, closed: Boolean = false) = {
    val d = data.toJSArray.map(_.toJSArray)
    SmoothLineNative(SmoothLineOpts(d, xaccessor, yaccessor, width, height, closed))
  }
}