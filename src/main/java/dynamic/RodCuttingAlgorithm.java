package dynamic;

import java.util.stream.IntStream;

public class RodCuttingAlgorithm {
    private final int[] prices;
    private final int[][] solution;

    public RodCuttingAlgorithm(int rodLength, int[] prices) {
        this.prices = prices;
        this.solution = new int[prices.length][rodLength + 1];
    }

    public void solve() {
        IntStream.range(1, solution.length).forEach(i ->
                IntStream.range(1, solution[0].length).forEach(j -> {
                    if (i > j) solution[i][j] = solution[i - 1][j];
                    else solution[i][j] = Math.max(solution[i - 1][j], prices[i] + solution[i][j - i]);
                }));
        printSolution();
    }

    private void printSolution() {
        StringBuilder res = new StringBuilder("Optimal profit: ");
        res.append(solution[solution.length - 1][solution[0].length - 1]);
        res.append("$\nPieces: ");

        for (int n = solution.length - 1, k = solution[0].length - 1; n > 0; ) {
            if (solution[n][k] != 0 && solution[n][k] != solution[n - 1][k]) {
                res.append(n).append("m, ");
                k -= n;
            } else {
                n--;
            }
        }
        System.out.println(res.substring(0, res.length() - 2));
    }

    public static void main(String[] args) {
        int rodLength = 5;
        int[] prices = {0, 2, 5, 7, 3, 9};
        new RodCuttingAlgorithm(rodLength, prices).solve();
    }
}
