package backtracking;

import java.util.Arrays;

// x - busy
// 0 - empty
// 1 - solution
// always start from left upper corner
// always end in right bottom corner
// we can move only to the left & down
// ex:  1 1 1 1 1
//      x x 0 x 1
//      0 0 0 x 1
//      x x x x 1
//      0 0 0 x 1
public class MazeProblem {
    private char[][] solution;

    public MazeProblem(char[][] maze) {
        this.solution = maze;
    }

    void solveTheMaze() {
        printResult(solve(0, 0));
    }

    private boolean solve(int x, int y) {
        if (x == solution.length - 1 && y == solution[x].length - 1) {
            solution[x][y] = '1';
            return true;
        }
        if (isValid(x, y)) {
            solution[x][y] = '1';
            if (solve(x, y + 1) || solve(x + 1, y)) return true;
            solution[x][y] = '0';
        }
        return false;
    }

    private boolean isValid(int x, int y) {
        return x < solution.length && x >= 0 &&
                y < solution[x].length && y >= 0 &&
                solution[x][y] != 'x';
    }

    private void printResult(boolean isSolved) {
        System.out.println(isSolved ? getSolution() : "No solution");
    }

    private String getSolution() {
        return Arrays.stream(solution).map(chars -> {
                    StringBuilder res = new StringBuilder();
                    for (char ch : chars) {
                        res.append(ch).append("\t");
                    }
                    return res.toString();
                })
                .reduce((r1, r2) -> r1 + "\n" + r2).orElse("");
    }

    public static void main(String[] args) {
        char[][] maze = {
                {'0', '0', '0', '0', '0'},
                {'x', 'x', '0', '0', '0'},
                {'0', '0', '0', '0', 'x'},
                {'x', 'x', 'x', '0', '0'},
                {'0', '0', '0', 'x', '0'}};
        new MazeProblem(maze).solveTheMaze();
    }
}
