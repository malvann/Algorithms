package dynamic;

import java.util.stream.IntStream;

public class KnapsackDynamic {
    private final int n;
    private final int capacity;
    private final int[][] solutionArr;
    private final int[] weightArr;
    private final int[] valueArr;

    public KnapsackDynamic(int n, int capacity, int[] weightArr, int[] valueArr) {
        this.n = n;
        this.capacity = capacity;
        this.weightArr = weightArr;
        this.valueArr = valueArr;
        this.solutionArr = new int[n + 1][capacity + 1];
    }

    public void solution() {
        IntStream.range(1, n + 1)
                .forEach(i -> IntStream.range(1, capacity + 1)
                        .forEach(w -> {
                            int notTakingItem = solutionArr[i - 1][w];
                            int takingItem = weightArr[i] <= w ? valueArr[i] + solutionArr[i - 1][w - weightArr[i]] : 0;
                            solutionArr[i][w] = Math.max(takingItem, notTakingItem);
                        }));
        showResult();
    }

    private void showResult() {
        StringBuilder res = new StringBuilder("Total benefit: " + solutionArr[n][capacity] + "\nItems: ");
        for (int i = n, w = capacity; i > 0; i--) {
            if (solutionArr[i][w] != 0 && solutionArr[i][w] != solutionArr[i - 1][w]) {
                res.append(i).append(", ");
                w -= weightArr[i];
            }
        }
        System.out.println(res.substring(0, res.length() - 2));
    }

    public static void main(String[] args) {
        int numOfNumbers = 4;
        int capacity = 7;
        int[] weight = {0, 1, 3, 4, 5};
        int[] profit = {0, 1, 4, 5, 7};

        new KnapsackDynamic(numOfNumbers, capacity, weight, profit).solution();
    }
}
