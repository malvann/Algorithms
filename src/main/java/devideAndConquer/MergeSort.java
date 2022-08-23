package devideAndConquer;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {
    private final int[] nums;
    private int[] tempArr;

    public MergeSort(int[] nums) {
        this.nums = nums;
        this.tempArr = new int[nums.length];
    }

    public void sort() {
        mergeSort(0, nums.length - 1);
        showArray();
    }

    private void mergeSort(int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) return;

        int midIndex = (lowIndex + highIndex) / 2;
        mergeSort(lowIndex, midIndex);
        mergeSort(midIndex + 1, highIndex);

        merge(lowIndex, midIndex, highIndex);
    }

    private void merge(int lowIndex, int midIndex, int highIndex) {
        tempArr = Arrays.copyOf(nums, nums.length);
        int i = lowIndex;
        int j = midIndex + 1;
        int k = lowIndex;
        while (i <= midIndex && j <= highIndex) {
            if (tempArr[i] < tempArr[j]) {
                nums[k] = tempArr[i];
                i++;
            } else {
                nums[k] = tempArr[j];
                j++;
            }
            k++;
        }

        while (i <= midIndex) {
            nums[k] = tempArr[i];
            ++k;
            ++i;
        }
        while (j <= midIndex) {
            nums[k] = tempArr[j];
            ++k;
            ++j;
        }
    }

    private void showArray() {
        System.out.println(IntStream.of(nums).mapToObj(n -> n + " ").reduce((s, s2) -> s + s2).orElse(""));
    }

    public static void main(String[] args) {
        int[] nums = {5, -1, 0, 7, 2, 3, 2, 1, 0, 1, 2};
        new MergeSort(nums).sort();
    }
}
