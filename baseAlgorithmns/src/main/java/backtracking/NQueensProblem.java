package backtracking;

import java.util.Arrays;

public class NQueensProblem {
    private final int[][] chessBoard;
    private final int numOfQueens;

    public NQueensProblem(int numOfQueens) {
        this.numOfQueens = numOfQueens;
        this.chessBoard = new int[numOfQueens][numOfQueens];
    }

    public void solve() {
        if (setQueens(0)) {
            print();
            return;
        }
        System.out.println("No solution");
    }

    private boolean setQueens(int colIndex) {
        if (colIndex == numOfQueens) return true;
        for (int rowIndex = 0; rowIndex < numOfQueens; rowIndex++) {
            if (isPlaceValid(rowIndex, colIndex)) {
                chessBoard[rowIndex][colIndex] = 1;
                if (setQueens(colIndex + 1)) return true;
                chessBoard[rowIndex][colIndex] = 0;
            }
        }
        return false;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex) {
        for (int i = 0; i < colIndex; i++)
            if (chessBoard[rowIndex][i] == 1) return false;
        for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--)
            if (chessBoard[i][j] == 1) return false;
        for (int i = rowIndex, j = colIndex; i < chessBoard.length && j >= 0; i++, j--)
            if (chessBoard[i][j] == 1) return false;
        return true;
    }

    private void print() {
        Arrays.stream(chessBoard).forEach(ints -> System.out.println(Arrays.stream(ints).boxed().toList()));
    }

    public static void main(String[] args) {
        NQueensProblem problem = new NQueensProblem(5);
        problem.solve();
    }
}
