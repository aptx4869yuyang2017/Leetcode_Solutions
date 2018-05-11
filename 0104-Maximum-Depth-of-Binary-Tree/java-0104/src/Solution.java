class Solution {
    public int maxDepth(TreeNode root) {
         int maxDepth = 0;
         if (root == null){
             return maxDepth;
         }

         maxDepth += Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
         return maxDepth;
    }
}
