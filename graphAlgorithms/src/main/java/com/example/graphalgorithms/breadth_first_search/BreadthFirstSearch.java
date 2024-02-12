package com.example.graphalgorithms.breadth_first_search;

import com.example.graphalgorithms.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public void traverse(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        root.setVisited(true);

        Node poll;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            poll.setVisited(true);
            queue.addAll(poll.getNextNodes());
            System.out.println(poll.getName());
        }
    }
}
