class Solution {
    public int minDepth(TreeNode root) {
        int curentDepth;
        if (root == null){
            curentDepth = 0;
            return curentDepth;
        }

        int leftmin = minDepth(root.left);
        if (leftmin == 0){
            leftmin = curentDepth;
        }
        int rightmin = minDepth(root.right);

        if (rightmin == 0) {
            rightmin = curentDepth;
        }


        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;



}