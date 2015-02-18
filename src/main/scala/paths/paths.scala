import scala.scalajs.js
import js.JSConverters._

package object paths {
  type Point = js.Array[Double]
  private[paths] def tuple2point(x: (Double, Double)) = js.Array(x._1, x._2)
}