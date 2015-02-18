package paths
package high

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._

import mid.{ CurvedRectangle, Rectangle }


trait SankeyData[V, E] extends js.Object {
  val nodes: js.Array[js.Array[V]] = js.native
  val links: js.Array[E] = js.native
}

trait SankeyEdge extends js.Object {
  val start: String = js.native
  val end: String = js.native
  val weight: Double = js.native
}

trait SankeyOpts[V, E] extends js.Object {
  val data: SankeyData[V, E] = js.native
  val nodeaccessor: js.Function1[V, String] = js.native
  val linkaccessor: js.Function1[E, SankeyEdge] = js.native
  val width: Int = js.native
  val height: Int = js.native
  val gutter: js.UndefOr[Int] = js.native
  val rect_width: js.UndefOr[Int] = js.native
}

object SankeyOpts {
  def apply[V, E](data: SankeyData[V, E], nodeaccessor: js.Function1[V, String],
      linkaccessor: js.Function1[E, SankeyEdge], width: Int, height: Int,
      gutter: Int = 10, rect_width: Int = 10): SankeyOpts[V, E] =
    js.Dynamic.literal(
      data = data,
      nodeaccessor = nodeaccessor,
      linkaccessor = linkaccessor,
      width = width,
      height = height,
      gutter = gutter,
      rect_width = rect_width
    ).asInstanceOf[SankeyOpts[V, E]]
}

@JSName("paths.Sankey")
object SankeyNative extends js.Object {
  def apply[V, E](options: SankeyOpts[V, E]): Sankey[V, E] = js.native
}

trait SankeyCurve[E] extends js.Object {
  val curve: CurvedRectangle = js.native
  val item: E = js.native
  val index: Int = js.native
}

trait SankeyNode[V] extends js.Object {
  val curve: Rectangle = js.native
  val item: V = js.native
  val index: Int = js.native
}

trait Sankey[V, E] extends js.Object {
  var curvedRectangles: js.Array[SankeyCurve[E]] = js.native
  var rectangles: js.Array[SankeyNode[V]] = js.native
}

object Sankey {
  type SankeyScalaEdge = { def start: String; def end: String; def weight: Double }

  def apply[V, E](nodes: Seq[Seq[V]], links: Seq[E], nodeaccessor: V => String, linkaccessor: E => SankeyScalaEdge,
      width: Int, height: Int, gutter: Int = 10, rectWidth: Int = 10) = {

    def dynamic(e: SankeyScalaEdge): SankeyEdge = js.Dynamic.literal(
      start = e.start,
      end = e.end,
      weight = e.weight
    ).asInstanceOf[SankeyEdge]

    val data = js.Dynamic.literal(
      nodes = nodes.toJSArray.map(_.toJSArray),
      links = links.toJSArray
    ).asInstanceOf[SankeyData[V, E]]

    SankeyNative(SankeyOpts(data, nodeaccessor, linkaccessor.andThen(dynamic),
      width, height, gutter, rectWidth))
  }
}