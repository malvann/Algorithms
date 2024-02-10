package com.example.graphalgorithms.depth_first_search;

import com.example.graphalgorithms.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

class DepthFirstSearchTest {

    @Test
    void dfs() {
        Node h = new Node("h", List.of());
        Node g = new Node("g", List.of(h));
        Node f = new Node("f", List.of());
        Node e = new Node("e", List.of());
        Node d = new Node("d", List.of(e));
        Node c = new Node("c", List.of());
        Node b = new Node("b", List.of(c, d));
        Node a = new Node("a", List.of(b, f, g));
        Node x = new Node("x", List.of());
        Node y = new Node("y", List.of(x));
        Node z = new Node("z", List.of(x, y));

        new DepthFirstSearch().dfs(List.of(a, b, c, d, e, f, g, h, e, z, y, x));
    }
}