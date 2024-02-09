package dynamic;

//max subarray problem
public class KadaneAlgorithm {
    public void solve(int[] nums) {
        int globalMax = nums[0];
        int localMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], localMax + nums[i]);
            if (localMax > globalMax) globalMax = localMax;
        }
        System.out.println(globalMax);
    }

    public static void main(String[] args) {
        new KadaneAlgorithm().solve(new int[]{1, -2, 3, 4, 1});
    }
}
