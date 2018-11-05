package paths
package high

import scala.scalajs.js
import js.annotation.JSGlobal
import js.JSConverters._

import mid.Connector


@js.native
trait TreeOpts[A] extends js.Object {
  val data: A = js.native
  val children: js.Function1[A, js.Array[A]] = js.native
  val width: Int = js.native
  val height: Int = js.native
}

object TreeOpts {
  def apply[A](data: A, children: js.Function1[A, js.Array[A]],
      width: Int, height: Int): TreeOpts[A] =
    js.Dynamic.literal(
      data = data.asInstanceOf[js.Any],
      children = children,
      width = width,
      height = height
    ).asInstanceOf[TreeOpts[A]]
}

@js.native
@JSGlobal("Paths.Tree")
object TreeNative extends js.Object {
  def apply[A](options: TreeOpts[A]): Tree[A] = js.native
}

@js.native
trait TreeCurve[A] extends js.Object {
  val connector: Connector = js.native
  val item: A = js.native
  val index: Int = js.native
}

@js.native
trait TreeNode[A] extends js.Object {
  val point: Point = js.native
  val item: A = js.native
}

@js.native
trait Tree[A] extends js.Object {
  val curves: js.Array[TreeCurve[A]] = js.native
  val nodes: js.Array[TreeNode[A]] = js.native
}

object Tree {
  def apply[A](data: A, children: A => Seq[A], width: Int, height: Int) = {
    val c = children.andThen(_.toJSArray)
    TreeNative(TreeOpts(data, c, width, height))
  }
}