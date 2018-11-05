package paths
package mid

import scala.scalajs.js
import js.annotation.JSGlobal
import js.JSConverters._


@js.native
trait ConnectorOpts extends js.Object {
  val start: Point = js.native
  val end: Point = js.native
}

object ConnectorOpts {
  def apply(start: Point, end: Point): ConnectorOpts =
    js.Dynamic.literal(
      start = start,
      end = end
    ).asInstanceOf[ConnectorOpts]
}

@js.native
@JSGlobal("Paths.Connector")
object ConnectorNative extends js.Object {
  def apply(options: ConnectorOpts): Connector = js.native
}

@js.native
trait Connector extends Shape

object Connector {
  def apply(start: (Double, Double), end: (Double, Double)): Connector = {
    val (a, b) = start
    val (c, d) = end
    ConnectorNative(ConnectorOpts(js.Array(a, b), js.Array(c, d)))
  }
}