package backtracking;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sudoku {
    private final int[][] solution;

    public Sudoku(int[][] sudoku) {
        this.solution = sudoku;
    }

    public void solve() {
        System.out.println(solve(0, 0) ? getSolution() : "No solution");
    }

    private boolean solve(int x, int y) {
        if (x == 9) {
            y++;
            if (y == 9) return true;
            x = 0;
        }
        if (solution[x][y] != 0) return solve(x + 1, y);

        for (int num : IntStream.range(1, 10).toArray()) {
            if (isValid(x, y, num)) {
                solution[x][y] = num;
                if (solve(x + 1, y)) return true;
                solution[x][y] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y, int num) {
        for (int i : IntStream.range(0, 9).toArray()) {
            if (solution[i][y] == num) return false;
        }
        int rowOffset = (x / 3) * 3;
        int colOffset = (y / 3) * 3;

        for (int i : IntStream.range(0, 3).toArray()) {
            for (int j : IntStream.range(0, 3).toArray()) {
                if (solution[rowOffset + i][colOffset + j] == num) return false;
            }
        }
        return true;
    }

    private String getSolution() {
        Stream<String> formattedRows = Stream.of(solution)
                .map(intArr -> Arrays.stream(intArr).mapToObj(String::valueOf))
                .map(strArr -> formatting(strArr, "  "));
        return formatting(formattedRows, "\n");
    }

    private String formatting(Stream<String> row, String spliterator) {
        return Lists.partition(row.toList(), 3).stream()
                .map(strList -> strList.stream().reduce((s1, s2) -> s1 + spliterator + s2).orElse(""))
                .reduce((p1, p2) -> p1 + spliterator + spliterator + p2).orElse("");
    }

    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        new Sudoku(sudoku).solve();
    }
}
