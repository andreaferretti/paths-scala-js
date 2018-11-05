package paths
package high

import scala.scalajs.js
import js.annotation.{JSGlobal, JSName}
import js.JSConverters._
import mid.Rectangle
import misc.Linear

@js.native
trait BarOpts[A] extends js.Object {
  val data: js.Array[js.Array[A]] = js.native
  val accessor: js.Function1[A, Double] = js.native
  val width: Int = js.native
  val height: Int = js.native
  val gutter: Int = js.native
  val offset: js.Array[Double] = js.native
}

object BarOpts {
  def apply[A](data: js.Array[js.Array[A]], accessor: js.Function1[A, Double],
      width: Int, height: Int, gutter: Int, offset: js.Array[Double]): BarOpts[A] =
    js.Dynamic.literal(
      data = data,
      accessor = accessor,
      width = width,
      height = height,
      gutter = gutter,
      offset = offset
    ).asInstanceOf[BarOpts[A]]
}

@js.native
@JSGlobal("Paths.Bar")
object BarNative extends js.Object {
  def apply[A](options: BarOpts[A]): Bar[A] = js.native
}

@js.native
trait BarCurve[A] extends js.Object {
  val line: Rectangle = js.native
  val item: A = js.native
  val index: Int = js.native
  val group: Int = js.native
}

@js.native
trait Bar[A] extends js.Object {
  val curves: js.Array[BarCurve[A]] = js.native
  val scale: Linear = js.native
}

object Bar {
  def apply[A](data: Seq[Seq[A]], accessor: A => Double, width: Int, height: Int, gutter: Int, offset: (Double, Double) = (0, 0)) = {
    val d = data.toJSArray.map(_.toJSArray)
    BarNative(BarOpts(d, accessor, width, height, gutter, tuple2point(offset)))
  }
}
