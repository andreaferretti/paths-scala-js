package paths
package mid

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._


@js.native
trait CurvedRectangleOpts extends js.Object {
  val topleft: Point = js.native
  val topright: Point = js.native
  val bottomleft: Point = js.native
  val bottomright: Point = js.native
}

object CurvedRectangleOpts {
  def apply(topleft: Point, topright: Point, bottomleft: Point, bottomright: Point): CurvedRectangleOpts =
    js.Dynamic.literal(
      topleft = topleft,
      topright = topright,
      bottomleft = bottomleft,
      bottomright = bottomright
    ).asInstanceOf[CurvedRectangleOpts]
}

@js.native
@JSName("Paths.CurvedRectangle")
object CurvedRectangleNative extends js.Object {
  def apply(options: CurvedRectangleOpts): CurvedRectangle = js.native
}

@js.native
trait CurvedRectangle extends Shape

object CurvedRectangle {
  def apply(topleft: (Double, Double), topright: (Double, Double),
    bottomleft: (Double, Double), bottomright: (Double, Double)): CurvedRectangle = {
    CurvedRectangleNative(CurvedRectangleOpts(tuple2point(topleft), tuple2point(topright),
      tuple2point(bottomleft), tuple2point(bottomright)))
  }
}