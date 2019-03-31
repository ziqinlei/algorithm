package com.ziqinlei.algorithm.graph;

/**
 * @author Leiziqin
 * @since 2019/3/31
 */
public class Edge {
    public int weight;
    public Node from;
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
