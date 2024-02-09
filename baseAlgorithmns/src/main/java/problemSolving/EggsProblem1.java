package problemSolving;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//The problem itself is that there are N number of eggs and building which has M floors. Write an algorithm to find
//the minimum number of drops is required to know the floor from which if egg is dropped, it will break.
//(usually N=2 and M=100)
@AllArgsConstructor
public class EggsProblem1 {
    private static int counter = 0;
    List<Boolean> floors;

    public void solve() {
        System.out.println(solve(0, floors.size()));
        System.out.println("Num of droppes: " + counter);
    }

    public int solve(int from, int to) {
        int midFloorNum = (from + to) / 2;
        counter++;
        if (midFloorNum == from) return floors.get(midFloorNum) ? -1 : midFloorNum;
        return isEggBroken(midFloorNum) ? solve(from, midFloorNum) : solve(midFloorNum, to);
    }

    private boolean isEggBroken(int floorNum) {
        return floors.get(floorNum);
    }

    public static void main(String[] args) {
        List<Boolean> floors = new ArrayList<>(Collections.nCopies(98, true));
        floors.add(0, false);
        floors.add(1, false);
        new EggsProblem1(floors).solve();
    }
}
