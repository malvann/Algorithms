package problemSolving;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

@AllArgsConstructor
public class DutchFlagProblem2 {
    private int[] nums;

    public void solve() {
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        int pivot = 1;
        while (j <= k) {
            if (nums[j] < pivot) {
                swap(i, j);
                i++;
                j++;
            } else if (nums[j] > pivot) {
                swap(j, k);
                k--;
            } else j++;
        }

        printResult(nums);
    }

    private void swap(int fromIndex, int toIndex) {
        int val = nums[fromIndex];
        nums[fromIndex] = nums[toIndex];
        nums[toIndex] = val;
    }

    private void printResult(int[] nums) {
        System.out.println(
                Arrays.stream(nums).mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")));
    }

    public static void main(String[] args) {
        new DutchFlagProblem1(new int[]{2, 2, 0, 1, 0, 2, 1}).solve();
    }
}
