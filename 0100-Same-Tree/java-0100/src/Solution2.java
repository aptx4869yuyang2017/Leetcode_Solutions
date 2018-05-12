// 判断两个二叉树是否相等
// 相比于递归的方法，代码复杂程度提升很多

// stack数据结构的使用，意味着是深度优先的遍历
// 主要的迭代过程是利用stack数据结构，每次push两个树位置相同的节点来判断
// 特殊情况主要是对 null 节点的判断，和递归方法是相似的
// 重点 在一次迭代过程中 维护好树结构 和 stack结构

// 另外如果用queue结构来遍历的话，广度优先遍历

import java.util.Stack;

public class Solution2 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        //if (p == null && q == null)
        //    return true;
        //
        //if (p == null || q == null)
        //    return false;

        Stack<TreeNode> stack = new Stack();

        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()){

            TreeNode temp_P = stack.pop();
            TreeNode temp_Q = stack.pop();

            if (temp_P != null && temp_Q != null){

                if (temp_P.val != temp_Q.val){
                    return false;
                } else {
                    stack.push(temp_P.left);
                    stack.push(temp_Q.left);
                    stack.push(temp_P.right);
                    stack.push(temp_Q.right);
                }

            } else if (temp_P == null && temp_Q ==null){
                continue;
            } else {
                return false;
            }

        }

        return true;

    }

}
