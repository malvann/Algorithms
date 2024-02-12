package com.example.graphalgorithms.topological_ordering;

import com.example.graphalgorithms.Node;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class WeightNode extends Node {
    private final List<Edge> neighbors;
    private int minDistance = Integer.MAX_VALUE;
    private WeightNode prevNode;

    public WeightNode(String name, List<Edge> neighbors) {
        super(name, Collections.emptyList());
        this.neighbors = neighbors;
    }

    public void setMinDistance(int distance) {
        this.minDistance = distance;
    }

    public void setPrevNode(WeightNode prevNode) {
        this.prevNode = prevNode;
    }
}
