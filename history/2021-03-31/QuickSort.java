/* 
日期：2021-03-31
实现快速排序
*/

/*
算法思想：动态规划
时间复杂度：O(nlogn)
空间复杂度：O(nlogn)
*/

class Solution {
    public static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) {
            return null;
        }
        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            QuickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            QuickSort(array, smallIndex + 1, end);
        }
        return array;
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end = start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i < smallIndex) {
                    swap(array, i, smallIndex);
                }
            }
        }
        return smallIndex;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}