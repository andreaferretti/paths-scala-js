package paths
package mid

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._


@js.native
trait RectangleOpts extends js.Object {
  val top: Double = js.native
  val bottom: Double = js.native
  val left: Double = js.native
  val right: Double = js.native
}

object RectangleOpts {
  def apply(top: Double, bottom: Double, left: Double, right: Double): RectangleOpts =
    js.Dynamic.literal(
      top = top,
      bottom = bottom,
      left = left,
      right = right
    ).asInstanceOf[RectangleOpts]
}

@js.native
@JSName("Paths.Rectangle")
object RectangleNative extends js.Object {
  def apply(options: RectangleOpts): Rectangle = js.native
}

@js.native
trait Rectangle extends Shape

object Rectangle {
  def apply(top: Double, bottom: Double, left: Double, right: Double): Rectangle = {
    RectangleNative(RectangleOpts(top, bottom, left, right))
  }
}