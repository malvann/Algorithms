package com.example.graphalgorithms.topological_ordering;

import com.example.graphalgorithms.Edge;
import com.example.graphalgorithms.Node;
import com.example.graphalgorithms.WeightNode;

import java.util.Deque;
import java.util.List;

public class FindMinDistance {
    private final TopologicalOrdering topologicalOrdering = new TopologicalOrdering();

    public void getShortestPath(List<WeightNode> nodes) {
        nodes.get(0).setWeight(0);

        Deque<Node> stack = topologicalOrdering.dfs(nodes);
        WeightNode pop;
        while (!stack.isEmpty()) {
            pop = ((WeightNode) stack.pop());
            for (Edge edge : pop.getNextEdges()) {
                if (edge.weight() + pop.getWeight() < edge.next().getWeight()) {
                    edge.next().setWeight(edge.weight() + pop.getWeight());
                    pop.setPrevNode(pop);
                }
            }
        }
    }
}
