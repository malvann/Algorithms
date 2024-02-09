package dynamic;

import java.util.stream.IntStream;

public class SubsetSum {
    private final boolean[][] solution;
    private final int[] nums;

    public SubsetSum(int[] nums, int sum) {
        this.nums = nums;
        this.solution = new boolean[nums.length + 1][sum + 1];
        IntStream.range(0, solution.length).forEach(i -> solution[i][0] = true);
    }

    public void solve() {
        IntStream.range(1, solution.length).forEach(n ->
                IntStream.range(1, solution[0].length).forEach(s -> {
                    if (s < nums[n - 1]) solution[n][s] = solution[n - 1][s];
                    else if (solution[n - 1][s]) solution[n][s] = solution[n - 1][s];
                    else solution[n][s] = solution[n - 1][s - nums[n - 1]];
                }));
        printResult();
    }

    private void printResult() {
        boolean solutionIsPresented = solution[solution.length - 1][solution[0].length - 1];
        StringBuilder result = new StringBuilder("Solution is presented: ");
        result.append(solutionIsPresented).append("\n");
        if (solutionIsPresented) {
            result.append("Subset: [");
            int n = solution.length - 1;
            int s = solution[0].length - 1;
            while (n > 0 || s > 0) {
                if (solution[n][s] == solution[n - 1][s]) n--;
                else {
                    result.append(nums[n - 1]).append(", ");
                    s -= nums[n - 1];
                }
            }
            result.delete(result.length() - 2, result.length());
            result.append("]");
            System.out.println(result);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 3, 6, 5, 9, 11};
        int sum = 43;
        new SubsetSum(nums, sum).solve();
    }
}
