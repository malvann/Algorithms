package problemSolving;

import lombok.AllArgsConstructor;

//Given n non-negative integers representing an elevation map where
// the width of each bar is 1. Compute how much water it can trap
// after raining!
//[4, 1, 3, 1, 5] - ex
//             x
// x  o  o  o  x
// x  o  x  o  x
// x  o  x  o  x
// x  x  x  x  x  result - 7

@AllArgsConstructor
public class RainWaterProblem1 {
    public int solve(int[] params) {
        int result = 0;
        int depth = params[0];
        int rDepth = params[params.length - 1];
        int current;
        for (int i = 1; i < params.length; i++) {
            current = depth - params[i];
            if (current >= 0) {
                params[i] = current;
                result += current;
            } else {
                depth = params[i];
                params[i] = current;
            }
        }
        //also is possible to chose min(params[0], params[length - 1]) to choose the start edge to minimize reverse iteration
        rDepth -= depth;
        if (rDepth < 0) {
            int i = params.length - 1;
            while (params[i] > 0) {
                current = params[i] + rDepth;
                if (current < 0) rDepth -= current;
                result += rDepth;
                i--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new RainWaterProblem1().solve(new int[]{4, 1, 3, 1, 5}) + " = 7");
        System.out.println(new RainWaterProblem1().solve(new int[]{5, 2, 3, 1, 6, 1, 4, 2, 3, 1, 3}) + " = 15");
        System.out.println(new RainWaterProblem1().solve(new int[]{4, 1, 3, 1, 5, 2, 7, 4, 8, 2, 5, 1, 2}) + " = 17");
    }
}
