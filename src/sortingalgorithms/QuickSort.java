package sortingalgorithms;
// Author: Christopher Dip
// Date: 08-25-2021
// MIT License
// Coding practice for DSA
// Time complexity of quick sort is:
// Ω(n log n) at best
// O(n log n) on average
// O(n^2) at worst
// Space complexity of quick sort is:
// O(n) at worst, recursion stack n levels deep
// O(log n) on average
//
// Also it is not a stable sorting algorithm
// As two equal keys R, S may appear in a different order such as S, R

public class QuickSort extends SortingAlgorithm{
    public static void sort(int[] array){
        // Recursive helper_method calls to sort
        helper_sort(array, 0, array.length -1);
    }

    // Recursive helper method
    public static void helper_sort(int[] array, int left, int right){
        if(left >= right) return;

        // Pick a pivot point in the middle of the array
        int pivot = array[left + (right-left)/2];

        // Partition the left and right side of the array
        // Left and right side are not necessarily separated at the pivot point
        int index = partition(array, left, right, pivot);

        // Recursive calls on both left and right arrays
        helper_sort(array, left, index -1);
        helper_sort(array, index, right);
    }

    public static int partition(int[] array, int left, int right, int pivot){
        while(left <= right){
            // Find a value on the left that is BIGGER than the pivot (should be on the other side)
            while(array[left] < pivot){
                left++;
            }

            // Find a value on the right that is SMALLER than the pivot (should be on the other side)
            while(array[right] > pivot){
                right--;
            }

            // If it is swappable (left <= right)
            if(left <= right){
                swap(array, left, right);
                left++;
                right--;
            }
        }

        // Return the partition point
        return left;
    }


}
