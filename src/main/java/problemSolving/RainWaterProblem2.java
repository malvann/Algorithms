package problemSolving;

public class RainWaterProblem2 {
    public int solve(int[] heights) {
        if (heights.length < 3) return 0;

        int[] leftMax = new int[heights.length];
        int[] rightMax = new int[heights.length];

        leftMax[0] = 0;
        rightMax[rightMax.length - 1] = 0;
        for (int i = 1, j = leftMax.length - 2; i < leftMax.length && j >= 0; i++, j--) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i - 1]);
            rightMax[j] = Math.max(rightMax[j + 1], heights[j + 1]);
        }
        int result = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            int current = Math.min(leftMax[i], rightMax[i]);
            if (current > heights[i])
                result += (current - heights[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RainWaterProblem2().solve(new int[]{4, 1, 3, 1, 5}) + " = 7");
        System.out.println(new RainWaterProblem2().solve(new int[]{5, 2, 3, 1, 6, 1, 4, 2, 3, 1, 3}) + " = 15");
        System.out.println(new RainWaterProblem2().solve(new int[]{4, 1, 3, 1, 5, 2, 7, 4, 8, 2, 5, 1, 2}) + " = 17");
    }
}
