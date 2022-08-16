package selection;

import java.util.Random;

public class QuickSelectSorting {
    private int[] nums;

    public QuickSelectSorting(int[] nums) {
        this.nums = nums;
    }

    public void sort() {
        for (int i = 1; i < nums.length + 1; ++i) {
            System.out.println(select(i));
        }
    }

    public int select(int k) {
        return quickSelect(0, nums.length - 1, k - 1);
    }

    private int quickSelect(int firstIndex, int lastIndex, int k) {
        int pivotIndex = partition(firstIndex, lastIndex);
        if (pivotIndex < k) return quickSelect(pivotIndex + 1, lastIndex, k);
        else if (pivotIndex > k) return quickSelect(firstIndex, pivotIndex - 1, k);
        return nums[pivotIndex];
    }

    private int partition(int firstIndex, int lastIndex) {
        int pivotIndex = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;
        swap(pivotIndex, lastIndex);
        for (int i = firstIndex; i < lastIndex; ++i) {
            if (nums[i] > nums[lastIndex]) {
                swap(i, firstIndex);
                firstIndex++;
            }
        }
        swap(lastIndex, firstIndex);
        return firstIndex;
    }

    private void swap(int pivot, int lastIndex) {
        int temp = nums[pivot];
        nums[pivot] = nums[lastIndex];
        nums[lastIndex] = temp;
    }

    public static void main(String[] args) {
        int[] container = new int[]{1, -5, 8, 3, -7, 10};
        QuickSelectSorting quickSelect = new QuickSelectSorting(container);
        quickSelect.sort();
    }
}
