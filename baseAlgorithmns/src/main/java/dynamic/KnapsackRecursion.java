package dynamic;

public class KnapsackRecursion {
    //    m - capacity of the knapsack, w - weights, v - values, n - number of items we consider
    public int solve(int m, int[] w, int[] v, int n) {
        if (m == 0 || n == 0) return 0;
        if (w[n - 1] > m) return solve(m, w, v, n - 1);
        int included = v[n - 1] + solve(m - w[n - 1], w, v, n - 1);
        int excluded = solve(m, w, v, n - 1);
        return Math.max(included, excluded);
    }

    public static void main(String[] args) {
        int numOfNumbers = 4;
        int capacity = 7;
        int[] weight = {0, 1, 3, 4, 5};
        int[] profit = {0, 1, 4, 5, 7};
        System.out.println(new KnapsackRecursion().solve(capacity, weight, profit, numOfNumbers));
    }
}
