package com.zds.leetcode.tree;

public class T104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        int max = 0;
        return maxDepth(root, max);
    }

    public static int maxDepth(TreeNode root, int max) {
        if (root == null) return max;
        return Math.max(maxDepth(root.left, max + 1), maxDepth(root.right, max + 1));
    }
}
