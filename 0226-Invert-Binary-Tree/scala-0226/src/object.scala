import java.lang.invoke.MutableCallSite

import javax.swing.tree

//Definition for a binary tree node.
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def invertTree(root: TreeNode): TreeNode = {
    if (root == null){
      return null
    }

    val leftnode: TreeNode = invertTree(root.left)
    val rightnode: TreeNode = invertTree(root.right)
    root.left = rightnode
    root.right = leftnode

    return root

  }
}

object Solution2 {
  def invertTree(root: TreeNode): TreeNode = {
    if(root==null)
      return root

    val q = scala.collection.mutable.Queue[TreeNode]()
    val p = scala.collection.mutable.Queue[TreeNode]()

    q+=root
    while (q.nonEmpty){
      val cur = q.dequeue()

      val temp = cur.left
      cur.left = cur.right
      cur.right = temp

      if (cur.left != null)
        q += cur.left
      if (cur.right != null)
        q += cur.right

    }

    return root

  }
}
