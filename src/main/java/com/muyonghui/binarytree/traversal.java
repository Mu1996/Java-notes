package com.muyonghui.binarytree;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class traversal {

    //后序
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        postorder(root,list);
        return list;
    }

    public void postorder(TreeNode node,ArrayList<Integer> list){
        if(node.left != null){
            postorder(node.left,list);
        }
        if(node.right != null){
            postorder(node.right,list);
        }
        list.add(node.val);
    }

    //前序
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return list;
        }
        preorder(root,list);
        return list;
    }

    public void preorder(TreeNode node,ArrayList<Integer> list){
        list.add(node.val);
        if(node.left != null){
            preorder(node.left,list);
        }
        if(node.right != null){
            preorder(node.right,list);
        }
    }

}
