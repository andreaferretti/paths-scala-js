package paths
package misc

import scala.scalajs.js
import js.annotation.JSGlobal

@js.native
@JSGlobal("Paths.Linear")
object LinearNative extends js.Object {
  def apply(source: js.Array[Double], target: js.Array[Double]): Linear = js.native
}

@js.native
trait Linear extends js.Object {
  def apply(x: Double): Double = js.native
  def inverse(): Linear = js.native
}

object Linear {
  def apply(source: (Double, Double), target: (Double, Double)): Linear = {
    val (a, b) = source
    val (c, d) = target
    LinearNative(js.Array(a, b), js.Array(c, d))
  }
}