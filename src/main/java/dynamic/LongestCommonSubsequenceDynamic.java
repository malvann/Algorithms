package dynamic;

import java.util.stream.IntStream;

public class LongestCommonSubsequenceDynamic {
    public String solve(String s1, String s2) {
        int[][] solution = new int[s1.length() + 1][s2.length() + 1];
        IntStream.range(1, solution.length).forEach(i ->
                IntStream.range(1, solution[0].length).forEach(j -> {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) solution[i][j] = solution[i - 1][j - 1] + 1;
                    else solution[i][j] = Math.max(solution[i][j - 1], solution[i - 1][j]);
                }));

        StringBuilder res = new StringBuilder();
        int i = s1.length();
        int j = s2.length();
        while (i > 0 && j > 0){
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                res.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (solution[i - 1][j] > solution[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String res = new LongestCommonSubsequenceDynamic().solve("abcd", "bd");
        System.out.println(res.isEmpty() ? "No result" : "Result: " + res);
    }
}
