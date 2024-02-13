package com.example.graphalgorithms.bellman_ford_algorithmn;

import com.example.graphalgorithms.Edge;
import com.example.graphalgorithms.WeightNode;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class BFAlgorithm {
    private List<WeightNode> nodes;

    public List<String> shortestPath(WeightNode start, WeightNode target) {
        run(start);

        if (target.getWeight() == Integer.MAX_VALUE) throw new RuntimeException("No solution");
        List<String> result = new ArrayList<>();
        while (target.getPrevNode() != null) {
            result.add(target.getName());
            target = target.getPrevNode();
        }
        return result;
    }

    private void run(WeightNode root) {
        root.setWeight(0);

        for (int i = 0; i < nodes.size() - 1; i++) {
            for (Edge edge : root.getNextEdges()) {
                WeightNode v = edge.next();
                if (root.getWeight() + edge.weight() < v.getWeight()) {
                    v.setWeight(root.getWeight() + edge.weight());
                    v.setPrevNode(root);
                }
            }
        }
        for (Edge edge : root.getNextEdges()) {
            if (root.getWeight() != Integer.MAX_VALUE && hasCircle(edge, root))
                System.out.println("Have a negative cycle...");
        }
    }

    private boolean hasCircle(Edge edge, WeightNode root) {
        return root.getWeight() + edge.weight() < edge.next().getWeight();
    }

}
