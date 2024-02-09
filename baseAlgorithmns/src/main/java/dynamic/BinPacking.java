package dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BinPacking {
    private final List<Item> itemList = new ArrayList<>();
    private final List<Bin> binList = new ArrayList<>();
    private final int binCapacity;

    BinPacking(List<Item> itemList, int numOfBins, int bicCapacity) {
        this.itemList.addAll(itemList);
        itemList.sort((o1, o2) -> o2.size() - o1.size());

        this.binCapacity = bicCapacity;
        IntStream.range(0, numOfBins).forEach(value -> binList.add(new Bin(bicCapacity)));
    }

    public void solve() {
        if (!itemList.isEmpty() && itemList.get(0).size() > binCapacity) {
            System.out.println("No solution");
            return;
        }

        boolean isSolved;
        for (Item item : itemList) {
            isSolved = false;
            for (Bin bin : binList) {
                isSolved = bin.put(item);
                if (isSolved) break;
            }
            if (!isSolved) {
                System.out.println("No solution");
                return;
            }
        }
        binList.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1));
        items.add(new Item(5));
        items.add(new Item(1));
        items.add(new Item(4));
        items.add(new Item(2));

        new BinPacking(items, 3, 5).solve();
    }
}

class Bin {
    private static int lastId = 0;
    private final int id;
    private final List<Item> itemList = new ArrayList<>();
    private final int capacity;
    private int actualSize = 0;

    public Bin(int capacity) {
        this.id = ++lastId;
        this.capacity = capacity;
    }

    public boolean put(Item item) {
        if (actualSize + item.size() > capacity) return false;
        itemList.add(item);
        actualSize += item.size();
        return true;
    }

    @Override
    public String toString() {
        return "Bin{" +
                "id=" + id +
                ", itemList=" + itemList +
                '}';
    }
}

record Item(int size) {
}
