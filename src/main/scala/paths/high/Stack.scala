package paths
package high

import scala.scalajs.js
import js.annotation.JSName
import js.JSConverters._

import mid.Rectangle


@js.native
trait StackOpts[A] extends js.Object {
  val data: js.Array[js.Array[A]] = js.native
  val accessor: js.Function1[A, Double] = js.native
  val width: Int = js.native
  val height: Int = js.native
  val gutter: Int = js.native
}

object StackOpts {
  def apply[A](data: js.Array[js.Array[A]], accessor: js.Function1[A, Double],
      width: Int, height: Int, gutter: Int): StackOpts[A] =
    js.Dynamic.literal(
      data = data,
      accessor = accessor,
      width = width,
      height = height,
      gutter = gutter
    ).asInstanceOf[StackOpts[A]]
}

@js.native
@JSName("Paths.Stack")
object StackNative extends js.Object {
  def apply[A](options: StackOpts[A]): Stack[A] = js.native
}

@js.native
trait StackCurve[A] extends js.Object {
  val line: Rectangle = js.native
  val item: A = js.native
  val index: Int = js.native
  val group: Int = js.native
}

@js.native
trait Stack[A] extends js.Object {
  val curves: js.Array[StackCurve[A]] = js.native
}

object Stack {
  def apply[A](data: Seq[Seq[A]], accessor: A => Double, width: Int, height: Int, gutter: Int) = {
    val d = data.toJSArray.map(_.toJSArray)
    StackNative(StackOpts(d, accessor, width, height, gutter))
  }
}