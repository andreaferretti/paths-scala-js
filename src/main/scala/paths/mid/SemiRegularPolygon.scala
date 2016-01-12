package paths
package mid

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._


@js.native
trait SemiRegularPolygonOpts extends js.Object {
  val center: Point = js.native
  val radii: js.Array[Double] = js.native
}

object SemiRegularPolygonOpts {
  def apply(center: Point, radii: js.Array[Double]): SemiRegularPolygonOpts =
    js.Dynamic.literal(
      center = center,
      radii = radii
    ).asInstanceOf[SemiRegularPolygonOpts]
}

@js.native
@JSName("Paths.SemiRegularPolygon")
object SemiRegularPolygonNative extends js.Object {
  def apply(options: SemiRegularPolygonOpts): SemiRegularPolygon = js.native
}

@js.native
trait SemiRegularPolygon extends Shape

object SemiRegularPolygon {
  def apply(center: (Double, Double), radii: Seq[Double]): SemiRegularPolygon = {
    val (x, y) = center
    SemiRegularPolygonNative(SemiRegularPolygonOpts(js.Array(x, y), radii.toJSArray))
  }
}