package com.example.graphalgorithms.bellman_ford_algorithmn;

import com.example.graphalgorithms.Edge;
import com.example.graphalgorithms.WeightNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BFAlgorithmTest {
    @Test
    void testCircled() {
        WeightNode c = new WeightNode("c", List.of());
        WeightNode b = new WeightNode("b", List.of(new Edge(c, 2)));
        WeightNode a = new WeightNode("a", List.of(new Edge(b, 5)));
        c = new WeightNode("c", List.of(new Edge(a, -10)));
        WeightNode finalC = c;

        BFAlgorithm bfAlgorithm = new BFAlgorithm(List.of(a, b, finalC));
        String errMsg = assertThrows(RuntimeException.class,
                () -> bfAlgorithm.shortestPath(a, finalC)).getMessage();

        assertEquals("No solution", errMsg);
    }

    @Test
    void testSuccess() {
        WeightNode c = new WeightNode("c", List.of());
        WeightNode b = new WeightNode("b", List.of(new Edge(c, 2)));
        WeightNode a = new WeightNode("a", List.of(new Edge(b, 5)));
        c = new WeightNode("c", List.of(new Edge(a, 10)));
        WeightNode finalC = c;

        assertEquals(List.of("a", "b", "c"), new BFAlgorithm(List.of(a, b, finalC)).shortestPath(a, finalC));
    }
}