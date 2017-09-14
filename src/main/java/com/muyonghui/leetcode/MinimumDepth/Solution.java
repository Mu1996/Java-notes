package com.muyonghui.leetcode.MinimumDepth;
/*
* Given a binary tree, find its minimum depth.
* The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
* */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public int run(TreeNode root) {
        if (root== null){
            return 0;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null){
            return run(right)+1;
        }
        if (right == null){
            return run(left)+1;

        }

        return Math.min(run(left),run(right))+1;
    }
}