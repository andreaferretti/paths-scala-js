package paths
package high

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._

import mid.Rectangle


trait WaterfallItem extends js.Object {
  val value: js.UndefOr[Double] = js.native
  val absolute: js.UndefOr[Boolean] = js.native
}

trait WaterfallScalaItem {
  def value: Option[Double]
  def absolute: Boolean
}

trait WaterfallOpts[A] extends js.Object {
  val data: js.Array[A] = js.native
  val accessor: js.Function1[A, WaterfallItem] = js.native
  val max: js.UndefOr[Double] = js.native
  val min: js.UndefOr[Double] = js.native
  val width: Int = js.native
  val height: Int = js.native
  val gutter: js.UndefOr[Int] = js.native
}

object WaterfallOpts {
  def apply[A](data: js.Array[A], accessor: js.Function1[A, WaterfallItem],
      max: js.UndefOr[Double], min: js.UndefOr[Double], width: Int, height: Int,
      gutter: js.UndefOr[Int]): WaterfallOpts[A] =
    js.Dynamic.literal(
      data = data,
      accessor = accessor,
      max = max,
      min = min,
      width = width,
      height = height,
      gutter = gutter
    ).asInstanceOf[WaterfallOpts[A]]
}

@JSName("paths.Waterfall")
object WaterfallNative extends js.Object {
  def apply[A](options: WaterfallOpts[A]): Waterfall[A] = js.native
}

trait WaterfallCurve[A] extends js.Object {
  val line: Rectangle = js.native
  val value: Double = js.native
  val item: A = js.native
  val index: Int = js.native
}

trait Waterfall[A] extends js.Object {
  val curves: js.Array[WaterfallCurve[A]] = js.native
}

object Waterfall {
  type WaterfallScalaItem = { def value: Option[Double]; def absolute: Boolean }

  def apply[A](data: Seq[A], accessor: A => WaterfallScalaItem, max: Option[Double] = None,
    min: Option[Double] = None, width: Int, height: Int, gutter: Option[Int] = None) = {

    def dynamic(s: WaterfallScalaItem): WaterfallItem = js.Dynamic.literal(
      value = s.value.orUndefined,
      absolute = s.absolute
    ).asInstanceOf[WaterfallItem]

    WaterfallNative(WaterfallOpts(data.toJSArray, accessor.andThen(dynamic), max.orUndefined, min.orUndefined,
      width, height, gutter.orUndefined))
  }
}