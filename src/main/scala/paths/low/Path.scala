package paths
package low

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

trait Path extends js.Object {
  def print(): String = js.native
  def points(): js.Array[Point] = js.native
  def connect(path: Path): Path = js.native

  def moveto(x: Number, y: Number): Path = js.native
  def lineto(x: Number, y: Number): Path = js.native
  def hlineto(x: Number): Path = js.native
  def vlineto(y: Number): Path = js.native
  def curveto(x1: Number, y1: Number, x2: Number, y2: Number, x: Number, y: Number): Path = js.native
  def smoothcurveto(x2: Number, y2: Number, x: Number, y: Number): Path = js.native
  def qcurveto(x1: Number, y1: Number, x: Number, y: Number): Path = js.native
  def smoothqcurveto(x: Number, y: Number): Path = js.native
  def arc(rx: Number, ry: Number, xrot: Number, large_arc_flag: Number, sweep_flag: Number, x: Number, y: Number): Path = js.native
  def closepath(): Path = js.native
}

@JSName("paths.Path")
object Path extends js.Object {
  def apply(): Path = js.native
}