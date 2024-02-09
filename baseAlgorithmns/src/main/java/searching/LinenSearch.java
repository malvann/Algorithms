package searching;

public class LinenSearch {

    public static void main(String[] args) {
        int[] container = new int[]{1, -5, 3, 8, 34};
        System.out.println(getIndex(container, 6));
        System.out.println(getIndexRecursion(container, 6, 0));
    }

    public static int getIndex(int[] container, int num) {
        for (int i = 0; i < container.length; i++) {
            if (container[i] == num) return i;
        }
        return -1;
    }

    public static int getIndexRecursion(int[] container, int num, int index) {
        if (container.length == index) return -1;
        if (container[index] == num) return index;
        return getIndexRecursion(container, num, ++index);
    }
}
