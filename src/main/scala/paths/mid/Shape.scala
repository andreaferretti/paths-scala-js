package paths
package mid

import scala.scalajs.js

import low.Path


@js.native
trait Shape extends js.Object {
  val path: Path = js.native
  val centroid: Point = js.native
}