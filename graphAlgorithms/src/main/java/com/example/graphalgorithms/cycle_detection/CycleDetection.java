package com.example.graphalgorithms.cycle_detection;

import java.util.List;

public class CycleDetection {
    public boolean detect(List<DetectionNode> graph) {
        for (DetectionNode node : graph) {
            if (!node.getIsVisited()) {
                boolean hasCycle = hasCycle(node);
                if (hasCycle) return true;
            }
        }
        return false;
    }

    private boolean hasCycle(DetectionNode node) {
        node.setIsBeingVisited(true);
        for (DetectionNode n : node.getCandidates()) {
            if (n.getIsBeingVisited()) return true;
            if (!n.getIsVisited()) {
                n.setAsVisited();
                hasCycle(n);
            }
        }
        node.setAsVisited();
        return false;
    }
}
