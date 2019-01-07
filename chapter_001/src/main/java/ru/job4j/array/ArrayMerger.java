package ru.job4j.array;

public class ArrayMerger {

    /**
     * Merges two sorted int arrays into a new sorted int array with duplicates if there were any.
     * @param first - first array, sorted in ascending order.
     * @param second - second array. sorted ascending.
     * @return merged array.
     */
    public int[] mergeTwo(int[] first, int[] second) {
        int[] ans = new int[first.length + second.length];
        int i = 0; //first pointer
        int j = 0; //second pointer
        int k = 0;
        while (k < first.length + second.length) {
            if (j >= second.length || i < first.length && first[i] < second[j]) {
                ans[k] = first[i];
                i++;
                k++;
            } else if (i >= first.length || first[i] > second[j]) {
                ans[k] = second[j];
                j++;
                k++;
            } else {
                ans[k] = first[i];
                ans[k + 1] = second[j];
                i++;
                j++;
                k += 2;
            }
        }
        return ans;
    }
}
