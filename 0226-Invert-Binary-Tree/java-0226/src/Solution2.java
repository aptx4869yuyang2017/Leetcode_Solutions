// 翻转二叉树 迭代法
// 对于迭代方法处理二叉树
// 1. 选取合适的数据结构
// 2. 在迭代过程中维护好链式结构，同时更新好辅助数据结构

// 时间复杂度：

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();

            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);

        }

        return root;

    }
}
