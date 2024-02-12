package com.example.graphalgorithms;

import lombok.Getter;

import java.util.List;

@Getter
public class Node {
    private final String name;
    private final List<Node> nextNodes;
    private boolean isVisited;

    public Node(String name, List<Node> children) {
        this.name = name;
        this.nextNodes = children;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
}
