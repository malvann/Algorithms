package backtracking;

import java.util.stream.IntStream;

public class GraphColoring1 {
    private final int numOfVertices;
    private final int numOfColors;
    private final int[] colorsSolution;
    private final int[][] graph;

    public GraphColoring1(int[][] graph, int numOfColors) {
        this.graph = graph;
        this.numOfColors = numOfColors;
        this.numOfVertices = graph[0].length;
        this.colorsSolution = new int[numOfVertices];
    }

    public void solve() {
        solveProblem(0);
        showResult();
    }

    private boolean solveProblem(int nodeIndex) {
        if (nodeIndex == numOfVertices) return true;
        for (int colorIndex = 1; colorIndex <= numOfColors; colorIndex++) {
            if (isColorValid(nodeIndex, colorIndex)) {
                colorsSolution[nodeIndex] = colorIndex;
                if (solveProblem(nodeIndex + 1)) return true;
            }
        }
        return false;
    }

    private boolean isColorValid(int nodeIndex, int colorIndex) {
        return IntStream.range(0, numOfVertices)
                .noneMatch(index -> graph[nodeIndex][index] == 1 && colorIndex == colorsSolution[index]);
    }

    private void showResult() {
        System.out.println(IntStream.range(0, colorsSolution.length).mapToObj(index ->
                        (String.format("Node(%d): %d", index, colorsSolution[index]))).reduce((s1, s2) -> s1 + "\n" + s2)
                .orElse("No solution"));
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 1, 1, 1, 0, 0},
                {1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 0}
        };
        new GraphColoring1(graph, 4).solve();
    }
}
