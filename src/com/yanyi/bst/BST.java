package com.yanyi.bst;

import java.util.Stack;

public class BST<E extends Comparable<E>> {
    //私有内部类
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    //根节点
    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        root = add(root,e);
    }

    //返回插入新节后二分搜索树的根
    public Node add(Node node, E e) {
        //递归终止的条件
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }
    public boolean contains (E e){
        return  contains(root, e);
    }
    private boolean contains(Node node, E e){
        if (node == null){
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
            //要查找的值比当前节点的值小则和他的左子树比较
        }else if (e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else {
            return contains(node.right,e);
        }
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if (node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //非递归的前序遍历的实现
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if (node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }
    private void generateBSTString(Node node,int depth,StringBuilder res){
        if (node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth)+ node.e + "\n");
        generateBSTString(node.left,depth+ 1,res);
        generateBSTString(node.right,depth+ 1,res);

    }
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }
}



//前序遍历的非递归写法

/**
 * 栈的基本操作
 * 记录下面访问多少节点
 * 系统栈
 */














