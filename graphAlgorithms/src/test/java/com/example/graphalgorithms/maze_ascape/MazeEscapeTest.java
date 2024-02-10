package com.example.graphalgorithms.maze_ascape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MazeEscapeTest {
    @Test
    void escape() {
        int[][] maze = {
                {1, 1, 1, 1, 1},
                {1, 2, 0, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 3}};
        char[][] result = new MazeEscape().escape(maze);
        char[][] expected = {
                {'-', '-', '-', '-', '-'},
                {'-', '2', 'S', '-', '-'},
                {'-', '-', 'S', '-', '-'},
                {'-', '-', 'S', 'S', 'S'},
                {'-', '-', '-', '-', '3'}};
        assertArrayEquals(expected, result);
    }
}