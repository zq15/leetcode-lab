package com.zds.leetcode.tree;

public class T226 {
    public TreeNode invertTree(TreeNode root) {
        // 递归 左树变右树 右树变左树
        if (root == null) return null;
        TreeNode node = new TreeNode();
        node.val = root.val;
        node.right = invertTree(root.left);
        node.left = invertTree(root.right);
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);
        System.out.println(treeNode);
        T226 t226 = new T226();
        TreeNode invertTree = t226.invertTree(treeNode);
        System.out.println(invertTree);
    }
}