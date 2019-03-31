package com.ziqinlei.algorithm.graph;

import java.util.*;

/**
 * kruskal算法
 * 适用范围：要求无向图
 *
 * @author Leiziqin
 * @since 2019/3/31
 */
public class Graph_004_Kruskal {
    /**
     * 并查集
     */
    private static class UnionFind {
        private Map<Node, Node> fatherMap;
        private Map<Node, Integer> rankMap;

        public UnionFind() {
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
        }

        private Node findFather(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findFather(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public void makeSets(Collection<Node> nodes) {
            fatherMap.clear();
            rankMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                rankMap.put(node, 1);
            }
        }

        public boolean isSameSet(Node a, Node b) {
            return findFather(a) == findFather(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aFather = findFather(a);
            Node bFather = findFather(b);
            if (aFather != bFather) {
                int aFrank = rankMap.get(aFather);
                int bFrank = rankMap.get(bFather);
                if (aFrank <= bFrank) {
                    fatherMap.put(aFather, bFather);
                    rankMap.put(bFather, aFrank + bFrank);
                } else {
                    fatherMap.put(bFather, aFather);
                    rankMap.put(aFather, aFrank + bFrank);
                }
            }
        }
    }

    /**
     * kruskal算法
     *
     * @param graph 图
     * @return 边集合
     */
    public static Set<Edge> kruskalMST(Graph graph) {
        UnionFind unionFind = new UnionFind();
        unionFind.makeSets(graph.nodes.values());
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for (Edge edge : graph.edges) {
            priorityQueue.offer(edge);
        }
        Set<Edge> result = new HashSet<>();
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!unionFind.isSameSet(edge.from, edge.to)) {
                result.add(edge);
                unionFind.union(edge.from, edge.to);
            }
        }
        return result;
    }
}
