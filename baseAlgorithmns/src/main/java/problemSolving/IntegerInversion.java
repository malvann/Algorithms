package problemSolving;

//Our task is to design an efficient algorithm to reverse a given integer.
//For example if the input of the algorithm is 1234 then the output should be 4321.
public class IntegerInversion {
    public int reverse(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 2147483412;
        System.out.println(new IntegerInversion().reverse(num));
    }
}
