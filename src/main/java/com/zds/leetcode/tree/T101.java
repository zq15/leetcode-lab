package com.zds.leetcode.tree;

public class T101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(TreeNode root) {
        boolean flag = true;
        isSymmetric(root, flag);
        return flag;
    }

    private static void isSymmetric(TreeNode root, boolean flag) {
        if (root == null) return;

    }
}
