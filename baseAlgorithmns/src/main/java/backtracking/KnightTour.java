package backtracking;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class KnightTour {
    private int[][] chessTable;
    private final int boardSize;
    private final int[] xMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] yMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    public KnightTour(int boardSize) {
        this.boardSize = boardSize;
        initializeChessTable(boardSize);
    }

    private void initializeChessTable(int size) {
        chessTable = Stream.generate(() -> IntStream.generate(() -> -1)
                        .limit(size)
                        .toArray())
                .limit(size).toArray(int[][]::new);
    }

    public void solve() {
        chessTable[0][0] = 0;
        System.out.println(solveProblem(1, 0, 0) ?
                getSolution() : "No solution");
    }

    public boolean solveProblem(int stepCount, int x, int y) {
        if (stepCount == boardSize * boardSize) return true;
        return IntStream.range(0, xMoves.length).anyMatch(moveIndex -> {
            int nextX = x + xMoves[moveIndex];
            int nextY = y + yMoves[moveIndex];
            if (isValid(nextX, nextY)) {
                chessTable[nextX][nextY] = stepCount;
                if (solveProblem(stepCount + 1, nextX, nextY)) return true;
                chessTable[nextX][nextY] = -1;
            }
            return false;
        });
    }

    private boolean isValid(int x, int y) {
        return (x >= 0 && x < boardSize) && (y >= 0 && y < boardSize) &&
                (chessTable[x][y] == -1);
    }

    private String getSolution() {
        return Arrays.stream(chessTable).map(ints ->
                        Arrays.stream(ints).mapToObj(String::valueOf).reduce((s1, s2) -> s1 + "\t" + s2).orElse(""))
                .reduce((r1, r2) -> r1 + "\n" + r2).orElse("");
    }

    public static void main(String[] args) {
        new KnightTour(4).solve();
    }
}
