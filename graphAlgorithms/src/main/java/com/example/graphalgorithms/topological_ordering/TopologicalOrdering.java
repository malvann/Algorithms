package com.example.graphalgorithms.topological_ordering;

import com.example.graphalgorithms.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TopologicalOrdering {
    private final Deque<Node> stack = new LinkedList<>();

    public Deque<Node> dfs(List<? extends Node> nodes) {
        for (Node node : nodes) {
            if (!node.isVisited()) crawl(node);
        }
        return stack;
    }

    private void crawl(Node node) {
        node.setVisited(true);

        for (Node n : node.getNextNodes()) {
            if (n.isVisited()) continue;
            crawl(n);
        }
        stack.addFirst(node);
    }
}
