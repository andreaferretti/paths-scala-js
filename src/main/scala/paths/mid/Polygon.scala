package paths
package mid

import scala.scalajs.js
import js.annotation.JSGlobal
import js.JSConverters._


@js.native
trait PolygonOpts extends js.Object {
  val points: js.Array[Point] = js.native
  val closed: Boolean = js.native
}

object PolygonOpts {
  def apply(points: js.Array[Point], closed: Boolean = false): PolygonOpts =
    js.Dynamic.literal(
      points = points,
      closed = closed
    ).asInstanceOf[PolygonOpts]
}

@js.native
@JSGlobal("Paths.Polygon")
object PolygonNative extends js.Object {
  def apply(options: PolygonOpts): Polygon = js.native
}

@js.native
trait Polygon extends Shape

object Polygon {
  def apply(points: Seq[(Double, Double)], closed: Boolean = false): Polygon = {
    val jsPoints = for ((x, y) <- points.toJSArray) yield js.Array(x, y)
    PolygonNative(PolygonOpts(jsPoints, closed))
  }
}