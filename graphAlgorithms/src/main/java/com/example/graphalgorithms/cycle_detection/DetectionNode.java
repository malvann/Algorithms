package com.example.graphalgorithms.cycle_detection;

import java.util.List;

public class DetectionNode {
    private boolean isBeingVisited;
    private final String name;
    private final List<DetectionNode> candidates;
    private boolean isVisited;

    public DetectionNode(String name, List<DetectionNode> candidates) {
        this.name = name;
        this.candidates = candidates;
    }

    public void setAsVisited() {
        this.isVisited = true;
    }

    public boolean getIsVisited() {
        return this.isVisited;
    }

    public void setAsBeingVisited() {
        this.isBeingVisited = true;
    }

    public boolean getIsBeingVisited() {
        return this.isBeingVisited;
    }

    public List<DetectionNode> getCandidates() {
        return this.candidates;
    }
}
