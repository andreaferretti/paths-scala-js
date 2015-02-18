package paths
package mid

import scala.scalajs.js

import low.Path


trait Shape extends js.Object {
  def path(): Path = js.native
  def centroid(): Point = js.native
}