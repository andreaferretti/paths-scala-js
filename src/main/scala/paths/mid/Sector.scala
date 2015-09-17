package paths
package mid

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._


@js.native
trait SectorOpts extends js.Object {
  val center: Point = js.native
  val r: Double = js.native
  val R: Double = js.native
  val start: Double = js.native
  val end: Double = js.native
}

object SectorOpts {
  def apply(center: Point, r: Double, R: Double, start: Double, end: Double): SectorOpts =
    js.Dynamic.literal(
      center = center,
      r = r,
      R = R,
      start = start,
      end = end
    ).asInstanceOf[SectorOpts]
}

@js.native
@JSName("paths.Sector")
object SectorNative extends js.Object {
  def apply(options: SectorOpts): Sector = js.native
}

@js.native
trait Sector extends Shape

object Sector {
  def apply(center: (Double, Double), r: Double, R: Double, start: Double, end: Double): Sector = {
    val (x, y) = center
    SectorNative(SectorOpts(js.Array(x, y), r, R, start, end))
  }
}