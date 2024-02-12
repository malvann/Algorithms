package com.example.graphalgorithms.topological_ordering;

import com.example.graphalgorithms.Node;

import java.util.Deque;
import java.util.List;

public class FindMinDistance {
    private final TopologicalOrdering topologicalOrdering = new TopologicalOrdering();

    public void getShortestPath(List<WeightNode> nodes) {
        nodes.get(0).setMinDistance(0);

        Deque<Node> stack = topologicalOrdering.dfs(nodes);
        WeightNode pop;
        while (!stack.isEmpty()) {
            pop = ((WeightNode) stack.pop());
            for (Edge edge : pop.getNeighbors()) {
                if (edge.weight() + pop.getMinDistance() < edge.target().getMinDistance()) {
                    edge.target().setMinDistance(edge.weight() + pop.getMinDistance());
                    pop.setPrevNode(pop);
                }
            }
        }
    }
}
