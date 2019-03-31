package com.ziqinlei.algorithm.graph;

import java.util.*;

/**
 * 拓扑排序算法
 * 适用范围：要求有向图，且有入度为0的节点，且没有环
 *
 * @author Leiziqin
 * @since 2019/3/31
 */
public class Graph_003_TopologySort {
    /**
     * 拓扑排序算法
     *
     * @param graph 图
     * @return 节点列表
     */
    public static List<Node> topologySort(Graph graph) {
        Map<Node, Integer> inMap = new HashMap<>();
        Queue<Node> zeroInQueue = new ArrayDeque<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()) {
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
