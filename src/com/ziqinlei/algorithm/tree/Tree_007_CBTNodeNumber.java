package com.ziqinlei.algorithm.tree;

/**
 * 已知一棵完全二叉树，求其节点的个数
 * 要求：时间复杂度低于O(N)，N为这棵树的节点个数
 * <p>
 * 思路：
 * 1. 获取节点最左节点所在层数 maxLevel
 * 2. 判断当前节点右子树最左节点是否也在 maxLevel
 * 若是，则当前节点左子树是满二叉树，当前节点右子树可以递归求其节点个数
 * 否则，当前节点右子树是满二叉树，只不过所在层数最大为 maxLevel-1，当前节点左子树可以递归求其节点个数
 *
 * @author Leiziqin
 * @since 2019/3/27
 */
public class Tree_007_CBTNodeNumber {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static int nodeNumber(Node node) {
        if (node == null) {
            return 0;
        }
        return count(node, 1, mostLeftLevel(node, 1));
    }

    /**
     * 当前节点下总节点个数
     *
     * @param node     当前节点
     * @param level    当前结点所在层数
     * @param maxLevel 最大层数
     * @return 当前节点下总节点个数
     */
    private static int count(Node node, int level, int maxLevel) {
        if (level == maxLevel) {
            return 1;
        }
        // 当前节点右子树的最左节点所在层数与最大层数相同，说明当前节点左子树是满二叉树
        if (mostLeftLevel(node.right, level + 1) == maxLevel) {
            return (1 << maxLevel - level) + count(node.right, level + 1, maxLevel);
        }
        // 当前节点右子树是满二叉树，只不过所在层数最大为最大层数-1
        return count(node.left, level + 1, maxLevel) + (1 << maxLevel - level - 1);
    }

    /**
     * 最左节点所在层
     *
     * @param node  结点
     * @param level 结点所在层
     * @return 最左结点所在层
     */
    private static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
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
        System.out.println(nodeNumber(head));
    }
}
