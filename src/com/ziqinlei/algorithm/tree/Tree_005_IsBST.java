package com.ziqinlei.algorithm.tree;

import java.util.Stack;

/**
 * 判断一棵树是否是搜索二叉树（Binary Search Tree）
 * <p>
 * 思路：
 * 中序遍历，判断是否为递增数组。
 * @author Leiziqin
 * @since 2019/3/27
 */
public class Tree_005_IsBST {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBST(Node node) {
        if (node == null) {
            return true;
        }
        Stack<Node> stack = new Stack<>();
        int preValue = Integer.MIN_VALUE;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.value <= preValue) {
                    return false;
                }
                preValue = node.value;
                node = node.right;
            }
        }
        return true;
    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(space);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(5);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
    }
}
