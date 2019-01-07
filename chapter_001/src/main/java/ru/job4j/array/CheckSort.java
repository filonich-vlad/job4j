package ru.job4j.array;

public class CheckSort {
    /**
     * Checks if an array is sorted in either ascending or descending order.
     * @param nums - array to check.
     * @return true if nums is sorted.
     */
    public boolean checkIfSorted(int[] nums) {
        boolean ans = true;
        for (int index = 2; index < nums.length; index++) {
            if ((nums[index - 2] - nums[index - 1]) * (nums[index - 1] - nums[index]) < 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
