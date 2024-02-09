package problemSolving;

import java.util.Arrays;

//Construct an algorithm to check whether two words (or phrases) are anagrams or not!
public class AnagramProblem {
    private static final String NO = "No";
    private static final String YES = "Yes";

    public void solve(String s1, String s2) {
        int[] source = s1.chars().sorted().toArray();
        int[] anagram = s2.chars().sorted().toArray();
        System.out.println(Arrays.equals(source, anagram) ? YES : NO);
    }

    public static void main(String[] args) {
        new AnagramProblem().solve("motor", "tormo");
    }
}
