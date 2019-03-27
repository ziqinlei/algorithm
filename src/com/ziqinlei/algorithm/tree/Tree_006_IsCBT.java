package com.ziqinlei.algorithm.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 判断一棵树是否是完全二叉树（Complete Binary Tree）
 *
 * 思路：
 * 层序遍历，增加一个是否已为叶子节点的标志位，初始值为false
 * 1. 如果头节点为null，直接返回false，否则将头节点放入队列中
 * 2. 当队列不为空时，弹出一个节点，判断
 * 3. 如果已为叶子节点，但当前节点的左节点或右节点不为null，则返回false
 * 4. 如果当前节点左节点为null，且右节点不为null，则返回false
 * 5. 如果当前节点左节点不为null，放入队列中
 * 6. 如果当前节点右节点不为null，放入队列中，否则说明已到达叶子节点，设置叶子节点标志位为true
 *
 * @author ziqin.lei
 * @since 2019-03-27
 */
public class Tree_006_IsCBT {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean isCBT(Node node) {
        if (node == null) {
            return false;
        }
        boolean isLeaf = false;
        Node left;
        Node right;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            left = node.left;
            right = node.right;
            if (isLeaf && (left != null || right != null)) {
                return false;
            }
            if (left == null && right != null) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                isLeaf = true;
            }
        }
        return true;
    }
}
