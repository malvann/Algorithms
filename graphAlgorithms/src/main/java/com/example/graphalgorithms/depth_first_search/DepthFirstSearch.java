package com.example.graphalgorithms.depth_first_search;

import com.example.graphalgorithms.Node;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class DepthFirstSearch {
    private final Deque<Node> stack = new ArrayDeque<>();

    public void dfs(List<Node> nodes) {
        for (Node node : nodes) {
            if (node.isVisited()) continue;

            node.setVisited(true);
            dfsHelper(node);
        }
    }

    private void dfsHelper(Node root) {
        stack.add(root);
        root.setVisited(true);

        Node pop;
        while (!stack.isEmpty()) {
            pop = stack.pop();

            for (Node node : pop.getNextNodes()) {
                if (node.isVisited()) continue;
                node.setVisited(true);
                stack.add(node);
            }
            pop.setVisited(true);
            System.out.println(pop.getName());
        }
    }
}
