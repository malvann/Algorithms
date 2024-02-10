package com.example.graphalgorithms;

import lombok.Getter;

import java.util.List;

@Getter
public class Node {
    private final String name;
    private final List<Node> children;
    private boolean isVisited;

    public Node(String name, List<Node> children) {
        this.name = name;
        this.children = children;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
}
