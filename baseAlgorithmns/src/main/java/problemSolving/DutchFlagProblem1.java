package problemSolving;

import java.util.Arrays;
import java.util.stream.Collectors;

//The problem is that we want to sort a T[] one-dimensional array of integers in O(N)
// running time - and without any extra memory. The array can contain values:
// 0, 1 and 2 (check out the theoretical section for further information).
public class DutchFlagProblem1 {
    private final int[] nums;
    int zeroInd;
    int twoInd;

    public DutchFlagProblem1(int[] nums) {
        this.nums = nums;
        this.twoInd = nums.length - 1;
    }

    public void solve() {
        for (int i = 0; i <= nums.length / 2; i++) {
            int currVal = nums[i];
            if (currVal == 0) zeroSwap(i);
            else if (currVal == 2) twoSwap(i);
        }
        printResult(nums);
    }

    private void zeroSwap(int index) {
        swap(index, zeroInd);
        zeroInd++;
    }

    private void twoSwap(int index) {
        if (nums[twoInd] == 2) twoInd--;
        swap(index, twoInd);
        twoInd--;
        if (nums[index] == 0) zeroSwap(index);
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
