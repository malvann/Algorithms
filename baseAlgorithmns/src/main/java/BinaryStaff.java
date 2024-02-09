public class BinaryStaff {
    public static void main(String[] args) {
        System.out.println(isOdd(3));
    }

    public static int multiply(int a, int b) {
//    if b is odd -> a * b = (a*2) * (b/2) + a
//    if b is even -> a * b = (a*2) * (b/2)
        int res = 0;
        while (b > 0) {
            if ((b ^ 1) == b - 1) {
                res = res + a;
            }
            a = a << 1;
            b = b >> 1;
        }
        return res;
    }

    public static int multiplyWithRecursion(int a, int b) {
        if (b == 1) return a; // base-case for recursion
        if (b % 2 == 1) return a + multiplyWithRecursion(2 * a, b / 2); // 'b' is an odd number - this is when we add 'a'
        return multiplyWithRecursion(2 * a, b / 2); // we do not consider numbers when 'b' is even
    }

    public static boolean isEven(int n) {
        //xor increment 1 for even numbers
        //xor decrement 1 for odd numbers
        return (n ^ 1) == n + 1;
    }

    public static boolean isOdd(int n) {
        return (n & 1) != 0;
    }

    public static void operators() {
        System.out.println("27: " + Integer.toBinaryString(27));
        System.out.println("15: " + Integer.toBinaryString(15));
        System.out.println("27 and 15: " + (27 & 15));
        System.out.println(Integer.toBinaryString(27 & 15));
        System.out.println("27 or 15: " + (27 | 15));
        System.out.println(Integer.toBinaryString(27 | 15));
        System.out.println("\n" + Integer.toBinaryString(27));
        System.out.println("27 << 1 = " + (27 << 1));
        System.out.println(Integer.toBinaryString(27 << 1));
        System.out.println("27 >> 1 = " + (27 >> 1));
        System.out.println(Integer.toBinaryString(27 >> 1));
    }
}
