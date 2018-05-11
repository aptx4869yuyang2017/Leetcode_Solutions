
object Solution {
  def maxDepth(root: TreeNode): Int = {
    if (root == null){
      return 0;
    }

    return 1 + math.max(maxDepth(root.left), maxDepth(root.right));
  }
}