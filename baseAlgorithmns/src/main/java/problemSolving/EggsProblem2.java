package problemSolving;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EggsProblem2 {
    private static final int EGG_NUM = 2;
    private static final int FLOORS_NUM = 100;

    private final int[][] dpTable = new int[EGG_NUM + 1][FLOORS_NUM + 1];

    private int solve() {
        dpTable[0][0] = 1;
        dpTable[1][0] = 1;

        IntStream.range(0, FLOORS_NUM).forEach(i -> dpTable[1][i] = i);
        for (int i = 2; i <= EGG_NUM; i++) {
            for (int j = 1; j <= FLOORS_NUM; j++) {
                dpTable[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    int maxDrops = 1 + Math.max(dpTable[i - 1][x - 1], dpTable[i][j - x]);
                    if (maxDrops < dpTable[i][j]) dpTable[i][j] = maxDrops;
                }
            }
        }
        printTable();
        return dpTable[EGG_NUM][FLOORS_NUM];
    }

    private void printTable() {
        String res = Stream.of(dpTable).map(ints -> Arrays.stream(ints).mapToObj(String::valueOf)
                        .reduce((i1, i2) -> i1 + "\t" + i2).orElse(""))
                .reduce((o1, o2) -> o1 + "\n" + o2).orElse("");
        System.out.println(res);
    }

    public static void main(String[] args) {
        System.out.println(new EggsProblem2().solve());
    }
}
