package paths
package mid

import scala.scalajs.js
import js.annotation.JSGlobal
import js.JSConverters._

@js.native
trait BezierOpts extends js.Object {
  val points: js.Array[Point] = js.native
  val tension: Double = js.native
}

object BezierOpts {
  def apply(points: js.Array[Point], tension: Double = 0.3): BezierOpts =
    js.Dynamic.literal(
      points = points,
      tension = tension
    ).asInstanceOf[BezierOpts]
}

@js.native
@JSGlobal("Paths.Bezier")
object BezierNative extends js.Object {
  def apply(options: BezierOpts): Bezier = js.native
}

@js.native
trait Bezier extends Shape

object Bezier {
  def apply(points: Seq[(Double, Double)], tension: Double = 0.3): Bezier = {
    val jsPoints = for ((x, y) <- points.toJSArray) yield js.Array(x, y)
    BezierNative(BezierOpts(jsPoints, tension))
  }
}