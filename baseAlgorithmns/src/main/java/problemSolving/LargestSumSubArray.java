package problemSolving;

//Create an algorithm to find the sum of contiguous subarray
// within a one-dimensional array of numbers which has the largest sum
public class LargestSumSubArray {
    public void solve(int[] nums) {
        int globalMax = nums[0];
        int localMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            globalMax = Math.max(globalMax, localMax);
        }
        System.out.println(globalMax);
    }

    public static void main(String[] args) {
        new LargestSumSubArray().solve(new int[]{1, -2, 3, 4, -5, 8});
    }
}
