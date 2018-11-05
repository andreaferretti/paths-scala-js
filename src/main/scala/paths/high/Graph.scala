package paths
package high

import scala.scalajs.js
import js.annotation.JSGlobal
import js.JSConverters._

import mid.Polygon


@js.native
trait GraphData[V, E] extends js.Object {
  val nodes: js.Array[V] = js.native
  val links: js.Array[E] = js.native
}

@js.native
trait GraphEdge extends js.Object {
  val start: String = js.native
  val end: String = js.native
  val weight: Double = js.native
}

@js.native
trait GraphOpts[V, E] extends js.Object {
  val data: GraphData[V, E] = js.native
  val nodeaccessor: js.Function1[V, String] = js.native
  val linkaccessor: js.Function1[E, GraphEdge] = js.native
  val width: Int = js.native
  val height: Int = js.native
  val attraction: js.UndefOr[Double] = js.native
  val repulsion: js.UndefOr[Double] = js.native
  val threshold: js.UndefOr[Double] = js.native
}

object GraphOpts {
  def apply[V, E](data: GraphData[V, E], nodeaccessor: js.Function1[V, String],
      linkaccessor: js.Function1[E, GraphEdge], width: Int, height: Int,
      attraction: Double = 1, repulsion: Double = 1, threshold: Double = 0.5): GraphOpts[V, E] =
    js.Dynamic.literal(
      data = data,
      nodeaccessor = nodeaccessor,
      linkaccessor = linkaccessor,
      width = width,
      height = height,
      attraction = attraction,
      repulsion = repulsion,
      threshold = threshold
    ).asInstanceOf[GraphOpts[V, E]]
}

@js.native
@JSGlobal("Paths.Graph")
object GraphNative extends js.Object {
  def apply[V, E](options: GraphOpts[V, E]): Graph[V, E] = js.native
}

@js.native
trait GraphCurve[E] extends js.Object {
  val link: Polygon = js.native
  val item: E = js.native
  val index: Int = js.native
}

@js.native
trait GraphNode[V] extends js.Object {
  val point: Point = js.native
  val item: V = js.native
}

@js.native
trait Graph[V, E] extends js.Object {
  var curves: js.Array[GraphCurve[E]] = js.native
  var nodes: js.Array[GraphNode[V]] = js.native
  def tick(): Graph[V, E] = js.native
  def constrain(id: String, coordinates: Point): Unit = js.native
  def unconstrain(id: String): Unit = js.native
}

object Graph {
  type GraphScalaEdge = { def start: String; def end: String; def weight: Double }

  def apply[V, E](nodes: Seq[V], links: Seq[E], nodeaccessor: V => String, linkaccessor: E => GraphScalaEdge,
      width: Int, height: Int, attraction: Double = 1, repulsion: Double = 1, threshold: Double = 0.5) = {

    def dynamic(e: GraphScalaEdge): GraphEdge = js.Dynamic.literal(
      start = e.start,
      end = e.end,
      weight = e.weight
    ).asInstanceOf[GraphEdge]

    val data = js.Dynamic.literal(
      nodes = nodes.toJSArray,
      links = links.toJSArray
    ).asInstanceOf[GraphData[V, E]]

    GraphNative(GraphOpts(data, nodeaccessor, linkaccessor.andThen(dynamic),
      width, height, attraction, repulsion, threshold))
  }
}