
public class BubbleSort {
    public static void main(String[] args) {
        int[] mas = {11, 3, 14, 16, 7};
        new BubbleSort().sort(mas);
        for (int i : mas) {
            System.out.print(i + " ");
        }
    }

    public void sort(int[] nums) {
        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    isSorted = false;

                    buf = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = buf;
                }
            }
        }
    }
}
