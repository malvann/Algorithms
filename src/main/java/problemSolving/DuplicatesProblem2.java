package problemSolving;

//For numbers 1..N & numbers.length > N
public class DuplicatesProblem2 {
    int[] numbers;
    StringBuilder result = new StringBuilder();

    public void solve(int[] nums) {
        this.numbers = nums;
        solve();
    }

    private void solve() {
        int x;
        for (int n : numbers) {
            x = numbers[Math.abs(n)];
            if (x > 0) {
                numbers[Math.abs(n)] = -x;
            } else {
                x = Math.abs(n);
                if (!result.toString().contains("" + x)) {
                    result.append(" ").append(x);
                }
            }
        }
        printResult();
    }

    private void printResult() {
        System.out.println(result.isEmpty() ? result.append("No result") : result);
    }

    public static void main(String[] args) {
        new DuplicatesProblem2().solve(new int[]{2, 3, 1, 2, 4, 3});
    }
}
