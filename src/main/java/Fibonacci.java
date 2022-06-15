import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibTail(10, 0, 1));
        System.out.println(fibHead(10));
    }

    public static List<Integer> fib(int counter, List<Integer> list) {
        if (counter == 0) return list;
        int lastInd = list.size() - 1;
        list.add(list.get(lastInd) + list.get(lastInd - 1));
        return fib(--counter, list);
    }

    public static int fibTail(int fibInd, int fib0, int fib1) {
        if (fibInd == 0) return fib0;
        if (fibInd == 1) return fib1;
        return fibTail(--fibInd, fib1, fib1 + fib0);
    }

    public static int fibHead(int fibInd) {
        if (fibInd == 0) return 0;
        if (fibInd == 1) return 1;
        int fib1 = fibHead(fibInd - 1);
        int fib2 = fibHead(fibInd - 2);
        return fib1 + fib2;
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(--n);
    }

    public static void factorial(int n, int accum) {
        if (n == 0) {
            System.out.println(accum);
            return;
        }
        factorial(n - 1, accum * n);
    }

    public static void head(int n) {
        if (n == 0) return;
        head(n - 1);
        System.out.println(n);
    }

    public static void tail(int n) {
        if (n == 0) return;
        System.out.println(n);
        tail(--n);
    }
}
