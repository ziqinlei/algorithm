package com.ziqinlei.algorithm.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 图的深度优先遍历
 * <p>
 * 思路：
 * 1. 利用栈实现
 * 2. 从源节点开始依次按照深度放入栈，然后弹出
 * 3. 每弹出一个节点，把该节点下一个没有进过栈的邻接点放入栈
 * 4. 直到栈变空
 *
 * @author Leiziqin
 * @since 2019/3/31
 */
public class Graph_002_DFS {
    /**
     * 图的深度优先遍历
     *
     * @param node 源节点
     */
    public static void dfs(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    break;
                }
            }
        }
    }
}
