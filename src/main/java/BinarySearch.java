public class BinarySearch {
    public static void main(String[] args) {
        int[] container = new int[]{1, 3, 4, 7, 9, 10, 43, 44, 50};
        System.out.println(search(container, 43, 0, container.length - 1));
    }

    public static int search(int[] container, int item, int fromInd, int toInd) {
        if (toInd < fromInd) return -1;
        int midInd = (toInd + fromInd) / 2;
        int curr = container[midInd];
        if (curr == item) return midInd;
        return curr > item ? search(container, item, fromInd, --midInd) : search(container, item, ++midInd, toInd);
    }
}
