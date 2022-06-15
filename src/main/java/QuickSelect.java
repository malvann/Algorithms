import java.util.Random;

public class QuickSelect {
    int[] container;

    public QuickSelect(int[] container) {
        this.container = container;
    }

    public int select(int k) {
        return quickSelect(0, container.length - 1, k - 1);
    }

    private int quickSelect(int firstInd, int lastInd, int kMinOne) {
        int pivot = partition(firstInd, lastInd);
        if (pivot > kMinOne) quickSelect(firstInd, pivot - 1, kMinOne);
        else if (pivot < kMinOne) quickSelect(pivot + 1, lastInd, kMinOne);
        return container[pivot];
    }

    private int partition(int firstInd, int lastInd) {
        int pivot = new Random().nextInt(lastInd - firstInd + 1) + firstInd;
        swap(pivot, lastInd);
        for (int i = firstInd; i < lastInd; i++) {
            if (container[i] < container[lastInd]) {
                swap(i, firstInd);
                firstInd++;
            }
        }
        swap(lastInd, firstInd);
        return firstInd;
    }

    private void swap(int ind1, int ind2) {
        int temp = container[ind1];
        container[ind1] = container[ind2];
        container[ind2] = temp;
    }

    public static void main(String[] args) {
        int[] container = new int[]{1, -5, 8, 3, -7, 10};
        QuickSelect quickSelect = new QuickSelect(container);
        System.out.println(quickSelect.select(3));
    }
}
