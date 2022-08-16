package dynamic;

public class LongestCommonSubsequenceRecursion {
    public int solve(String s1, String s2, int i, int j) {
        if (i == 0 || j == 0) return 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return 1 + solve(s1, s2, i - 1, j - 1);
        else {
            int x = solve(s1, s2, i - 1, j);
            int y = solve(s1, s2, i, j - 1);
            return Math.max(x, y);
        }
    }

    public static void main(String[] args) {
        String s1 = "asdftr";
        String s2 = "adr";
        System.out.println(new LongestCommonSubsequenceRecursion().solve(s1, s2, s1.length(), s2.length()));
    }
}
