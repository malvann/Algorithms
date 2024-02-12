package com.example.graphalgorithms.shortest_path;

import com.example.graphalgorithms.Edge;
import com.example.graphalgorithms.WeightNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPath {
    public Queue<String> computePath(WeightNode root, WeightNode target) {
        calculatePath(root);
        LinkedList<String> shortestPath = new LinkedList<>();
        while (target.getPrevNode() != null) {
            shortestPath.addFirst(target.getName());
            target = target.getPrevNode();
        }
        return shortestPath;
    }

    private void calculatePath(WeightNode root) {
        root.setWeight(0);
        Queue<WeightNode> queue = new PriorityQueue<>();
        queue.add(root);

        WeightNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            for (Edge e : node.getNextEdges()) {
                WeightNode next = e.next();
                int weight = node.getWeight() + e.weight();
                if (weight >= next.getWeight()) continue;

                queue.remove(node);
                next.setWeight(weight);
                next.setPrevNode(node);
                queue.add(next);
            }
        }
    }
}
