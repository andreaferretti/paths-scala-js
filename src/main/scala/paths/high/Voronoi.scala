package paths
package high

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._

import mid.Sector


@js.native
trait VoronoiOpts[A] extends js.Object {
  val data: js.Array[A] = js.native
  val accessor: js.Function1[A, Point] = js.native
  val xrange: Point = js.native
  val yrange: Point = js.native
  val width: Int = js.native
  val height: Int = js.native
}

object VoronoiOpts {
  def apply[A](data: js.Array[A], accessor: js.Function1[A, Point],
      xrange: Point, yrange: Point, width: Int, height: Int): VoronoiOpts[A] =
    js.Dynamic.literal(
      data = data,
      accessor = accessor,
      xrange = xrange,
      yrange = yrange,
      width = width,
      height = height
    ).asInstanceOf[VoronoiOpts[A]]
}

@js.native
@JSName("Paths.Voronoi")
object VoronoiNative extends js.Object {
  def apply[A](options: VoronoiOpts[A]): Voronoi[A] = js.native
}

@js.native
trait VoronoiCurve[A] extends js.Object {
  val line: Sector = js.native
  val item: A = js.native
  val index: Int = js.native
}

@js.native
trait VoronoiPoint[A] extends js.Object {
  val point: Point = js.native
  val item: A = js.native
}

@js.native
trait Voronoi[A] extends js.Object {
  val curves: js.Array[VoronoiCurve[A]] = js.native
  val nodes: js.Array[VoronoiPoint[A]] = js.native
}

object Voronoi {
  def apply[A](data: Seq[A], accessor: A => (Double, Double),
    xrange: (Double, Double), yrange: (Double, Double), width: Int, height: Int) = {

    val acc: js.Function1[A, Point] = accessor andThen tuple2point

    VoronoiNative(VoronoiOpts(data.toJSArray, acc, tuple2point(xrange), tuple2point(yrange), width, height))
  }
}