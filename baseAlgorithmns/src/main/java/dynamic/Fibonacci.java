package dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Fibonacci {
    private final Map<Integer, Integer> fibNumbersMap = new HashMap<>(Map.of(0, 1, 1, 1));

    public int fibonacciRecursion(int n) {
        if (n == 0 || n == 1) return 1;
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public int fibonacciMemorization(int n) {
        if (!fibNumbersMap.containsKey(n))
            fibNumbersMap.put(n, fibonacciMemorization(n - 1) + fibonacciMemorization(n - 2));
        return fibNumbersMap.get(n);
    }

    public int fibonacciTabulation(int n) {
        IntStream.range(2, n + 1)
                .forEach(num -> fibNumbersMap.put(num, fibNumbersMap.get(num - 1) + fibNumbersMap.get(num - 2)));
        return fibNumbersMap.get(n);
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacciRecursion(8));
        System.out.println(new Fibonacci().fibonacciMemorization(8));
        System.out.println(new Fibonacci().fibonacciTabulation(8));
    }
}
