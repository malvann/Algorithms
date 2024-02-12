package com.example.graphalgorithms.shortest_path;

import com.example.graphalgorithms.Edge;
import com.example.graphalgorithms.WeightNode;
import org.junit.jupiter.api.Test;

import java.util.List;

class ShortestPathTest {
    @Test
    void test() {
        WeightNode g = new WeightNode("g", List.of());
        WeightNode f = new WeightNode("f", List.of(new Edge(g, 13)));
        WeightNode d = new WeightNode("d", List.of(new Edge(g, 9)));
        WeightNode c = new WeightNode("c", List.of(new Edge(d, 3), new Edge(g, 11)));
        WeightNode h = new WeightNode("h", List.of(new Edge(c, 7), new Edge(f, 6)));
        WeightNode b = new WeightNode("b", List.of(new Edge(h, 4), new Edge(c, 12), new Edge(d, 15)));
        WeightNode e = new WeightNode("e", List.of(new Edge(h, 5), new Edge(f, 4), new Edge(g, 20)));
        WeightNode a = new WeightNode("a", List.of(new Edge(b, 5), new Edge(e, 8), new Edge(h, 9)));
        System.out.println(new ShortestPath().computePath(a, g));
    }
}