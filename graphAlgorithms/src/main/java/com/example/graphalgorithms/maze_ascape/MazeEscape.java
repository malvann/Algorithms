package com.example.graphalgorithms.maze_ascape;

public class MazeEscape {
    private static final int WALL = 1;
    private static final int START = 2;
    private static final int FINISH = 3;
    private static final char TRACK_MARK = 'S';
    private static final char EMPTY_MARK = '-';
    private int[][] maze;
    private char[][] solution;

    public char[][] escape(int[][] arr) {
        this.maze = arr;
        solution = new char[maze.length][maze.length];

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (maze[i][j] == START) {
                    solution[i][j] = String.valueOf(START).charAt(0);
                    crawl(i, j);
                    break;
                }
            }
        }

        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution.length; j++) {
                if (solution[i][j] == Character.MIN_VALUE) solution[i][j] = EMPTY_MARK;
            }
        }
        return solution;
    }

    private void crawl(int i, int j) {
        if (maze[i][j] == FINISH) {
            solution[i][j] = String.valueOf(FINISH).charAt(0);
            return;
        } else matchAsEmpty(i, j);

        if (available(i, j - 1)) {
            crawl(i, j - 1);
            matchAsTrack(i, j - 1);
        }
        if (available(i, j + 1)) {
            crawl(i, j + 1);
            matchAsTrack(i, j + 1);
        }
        if (available(i - 1, j)) {
            crawl(i - 1, j);
            matchAsTrack(i - 1, j);
        }
        if (available(i + 1, j)) {
            crawl(i + 1, j);
            matchAsTrack(i + 1, j);
        }
    }

    private boolean available(int i, int j) {
        return i < maze.length && i > -1
                && j < maze.length && j > -1
                && maze[i][j] != WALL
                && solution[i][j] == Character.MIN_VALUE;
    }

    private void matchAsTrack(int i, int j) {
        if (solution[i][j] == EMPTY_MARK) solution[i][j] = TRACK_MARK;
    }

    private void matchAsEmpty(int i, int j) {
        if (solution[i][j] == Character.MIN_VALUE) solution[i][j] = EMPTY_MARK;
    }
}
