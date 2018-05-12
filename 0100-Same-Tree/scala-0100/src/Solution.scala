

//Definition for a binary tree node.
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null)
      return true

    else if (p == null || q == null)
      return false

    else if (p.value == q.value)
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)

    else
      return false

  }
}