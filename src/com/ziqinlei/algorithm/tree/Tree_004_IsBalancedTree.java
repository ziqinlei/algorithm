package com.ziqinlei.algorithm.tree;

/**
 * 判断一棵二叉树是否是平衡二叉树
 * <p>
 * 平衡二叉树：对于任何一个结点，它的左子树和右子树高度差不超过1。
 * <p>
 * 思路：
 * 递归，从下往上遍历，如果子树是平衡的，则返回子树的高度；否则返回-1，表示不平衡
 *
 * @author Leiziqin
 * @since 2019/3/26
 */
public class Tree_004_IsBalancedTree {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isBalance(Node node) {
        return getDepth(node) != -1;
    }

    /**
     * 获取高度
     *
     * @param node 结点
     * @return 高度
     */
    private static int getDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(node.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));
    }
}
