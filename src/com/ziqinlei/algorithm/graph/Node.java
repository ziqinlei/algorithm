package com.ziqinlei.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leiziqin
 * @since 2019/3/31
 */
public class Node {
    public int value;
    public int in;
    public int out;
    public List<Node> nexts;
    public List<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
