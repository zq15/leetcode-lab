package com.zds.leetcode.tree;

/**
 * 二叉搜索树，寻找两个节点的最近公共祖先
 *  *分析: 从根节点出发，如果节点的值小于p和q的值，则当前节点在p和q的左边，反之在右边；
 *  如果正好在中间，此时即是最近公共祖先，返回当前节点；
 */
public class T235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        // 利用BST的性质
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // 当前节点位于p和q之间，或者等于其中一个节点
            return root;
        }
    }


    public static void main(String[] args) {
        // [3,5,1,6,2,0,8,null,null,7,4]
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new T235().lowestCommonAncestor(root, root.left, root.right));
    }
}
