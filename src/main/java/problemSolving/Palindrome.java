package problemSolving;

public class Palindrome {

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.toCharArray()[i] != s.toCharArray()[s.length() - 1 - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "qwerrewq";
        System.out.println(new Palindrome().isPalindrome(s));
    }
}
