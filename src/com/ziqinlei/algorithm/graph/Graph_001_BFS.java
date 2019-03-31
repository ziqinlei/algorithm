package com.ziqinlei.algorithm.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 图的广度优先遍历
 * <p>
 * 思路：
 * 1. 利用队列实现
 * 2. 从源节点开始依次按照广度进队列
 * 3. 每弹出一个节点，把该节点所有没有进过队列的邻接点放入队列
 * 4. 直到队列变空
 *
 * @author Leiziqin
 * @since 2019/3/31
 */
public class Graph_001_BFS {

    /**
     * 图的广度优先遍历
     *
     * @param node 　源节点
     */
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> set = new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.value);
            for (Node next : cur.nexts) {
                if (!set.contains(next)) {
                    queue.add(next);
                    set.add(next);
                }
            }
        }
    }
}
