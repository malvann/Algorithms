package problemSolving;

import java.util.HashMap;
import java.util.Map;

//The problem is that we want to find duplicates in a one-dimensional array
// of integers in O(N) running time where the integer values are smaller than the length of the array!
public class DuplicatesProblem1 {
    private final Map<Integer, Integer> duplicates = new HashMap<>();

    public void solve(int[] nums) {
        for (int n : nums) {
            duplicates.computeIfPresent(n, (k, v) -> v + 1);
            duplicates.putIfAbsent(n, 1);
        }
        String res = duplicates.entrySet().stream()
                .filter(entry -> entry.getValue() > 1).map(entry -> String.valueOf(entry.getKey()))
                .reduce((k1, k2) -> k1 + ", " + k2).orElse("No");
        System.out.println("Duplicates: " + res);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 4, 8, 9, 8};
        new DuplicatesProblem1().solve(nums);
    }
}
