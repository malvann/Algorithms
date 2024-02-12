package com.example.graphalgorithms.depth_first_search;

import com.example.graphalgorithms.Node;

import java.util.List;

public class DepthFirstSearchRecursion {

    public void dfs(List<Node> nodes) {
        for (Node node : nodes) {
            if (node.isVisited()) continue;

            node.setVisited(true);
            dfsHelper(node);
        }
    }

    private void dfsHelper(Node root) {
        for (Node node : root.getNextNodes()) {
            if (node.isVisited()) return;

            node.setVisited(true);
            dfsHelper(node);
        }

        System.out.println(root.getName());
    }
}
