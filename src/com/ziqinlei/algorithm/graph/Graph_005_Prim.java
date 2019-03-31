package com.ziqinlei.algorithm.graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * prim算法
 * 适用范围：要求无向图
 *
 * @author Leiziqin
 * @since 2019/3/31
 */
public class Graph_005_Prim {

    /**
     * prim算法
     *
     * @param graph 图
     * @return 边集合
     */
    public static Set<Edge> primMST(Graph graph) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Set<Node> set = new HashSet<>();
        Set<Edge> result = new HashSet<>();
        for (Node node : graph.nodes.values()) {
            if (!set.contains(node)) {
                set.add(node);
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if (!set.contains(toNode)) {
                        set.add(toNode);
                        result.add(edge);
                        priorityQueue.addAll(toNode.edges);
                    }
                }
            }
        }
        return result;
    }
}
