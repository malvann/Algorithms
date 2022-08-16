package backtracking;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HamiltonianCycle {
    private final int numOfVertexes;
    private int[] hamiltonianPath;
    private final int[][] adjacencyMatrix;

    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numOfVertexes = adjacencyMatrix[0].length;
        this.hamiltonianPath = new int[numOfVertexes];
    }

    public void solve() {
        hamiltonianPath[0] = 0;
        if (!findSolution(1)) hamiltonianPath = new int[]{};
        showResult();
    }

    private boolean findSolution(int position) {
        if (position == numOfVertexes) {
            return adjacencyMatrix[hamiltonianPath[position - 1]][hamiltonianPath[0]] == 1;
        }
        for (int index = 0; index < numOfVertexes; index++) {
            if (isValid(index, position)) {
                hamiltonianPath[position] = index;
                if (findSolution(position + 1)) return true;
            }
        }
        return false;
    }

    private boolean isValid(int vertex, int actualPosition) {
        if (adjacencyMatrix[hamiltonianPath[actualPosition - 1]][vertex] == 0) return false;
        return IntStream.range(0, actualPosition).noneMatch(i -> hamiltonianPath[i] == vertex);
    }

    private void showResult() {
        Arrays.stream(hamiltonianPath).mapToObj(String::valueOf)
                .reduce((s1, s2) -> s1 + "-" + s2).ifPresentOrElse(
                        s -> System.out.println("Hamiltonian cycle exists: " + s + "-" + hamiltonianPath[0]),
                        () -> System.out.println("Hamiltonian cycle not exists"));
    }

    public static void main(String[] args) {
// a - b - c - e -     f - a
//             e - d - f
        int[][] adjacencyMatrix = {
                //a  b  c  d  e  f
                {0, 1, 0, 0, 0, 1},//a
                {1, 0, 1, 0, 0, 0},//b
                {0, 1, 0, 0, 1, 0},//c
                {0, 0, 0, 0, 1, 1},//d
                {0, 0, 1, 1, 0, 1},//e
                {1, 0, 0, 1, 1, 0}};//f
        new HamiltonianCycle(adjacencyMatrix).solve();
    }
}
