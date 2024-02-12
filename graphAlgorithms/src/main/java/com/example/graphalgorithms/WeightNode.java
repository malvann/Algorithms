package com.example.graphalgorithms;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class WeightNode extends Node implements Comparable<WeightNode> {
    private final List<Edge> nextEdges;
    private int weight = Integer.MAX_VALUE;
    private WeightNode prevNode;

    public WeightNode(String name, List<Edge> neighbors) {
        super(name, Collections.emptyList());
        this.nextEdges = neighbors;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setPrevNode(WeightNode prevNode) {
        this.prevNode = prevNode;
    }

    @Override
    public int compareTo(WeightNode o) {
        return this.weight - o.getWeight();
    }

    public String toString() {
        return this.getName();
    }
}
