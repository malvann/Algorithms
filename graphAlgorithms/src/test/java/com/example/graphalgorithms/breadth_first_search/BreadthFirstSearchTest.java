package com.example.graphalgorithms.breadth_first_search;

import com.example.graphalgorithms.Node;
import org.junit.jupiter.api.Test;

import java.util.List;

class BreadthFirstSearchTest {

    @Test
    void traverse() {
        Node e = new Node("e", List.of());
        Node h = new Node("h", List.of());
        Node d = new Node("d", List.of(e));
        Node c = new Node("c", List.of());
        Node b = new Node("b", List.of(c, d));
        Node f = new Node("f", List.of());
        Node g = new Node("g", List.of(h));
        Node a = new Node("a", List.of(b, f, g));

        new BreadthFirstSearch().traverse(a);
    }

}