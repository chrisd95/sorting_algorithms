package sortingalgorithms;
// Author: Christopher Dip
// Date: 08-25-2021
// MIT License
// Coding practice for DSA
// Time complexity of quick sort is:
// Ω(n log n) at best
// O(n log n) on average
// O(n log n) at worst
// Space complexity of quick sort is:
// O(n) at worst, recursion stack n levels deep

public class MergeSort extends SortingAlgorithm{
    public static void sort(int[] array){
        int left = 0;
        int right = array.length-1;
        // Helper method recursion
        helper_sort(array,new int[array.length], left, right);
    }

    // The merge sort helper method needs the array, left and right pointers
    // As well as a temporary array in which we merge the sorted array
    public static void helper_sort(int[] array, int[] tmp, int left, int right){
        // Base case for recursive calls
        if(left >= right) return;

        // Calculate midPoint the good way avoiding overflow
        int midPoint = left + (right - left) /2;

        // Recursive calls to sort left and right sides by splitting in half
        // Sort left side
        helper_sort(array, tmp, left, midPoint);
        // Sort right side
        helper_sort(array, tmp, midPoint+1, right);


        // Once the left and right are sorted we merge
        merge(array, tmp, left, right);
    }

    public static void merge(int[] array, int[] tmp, int leftStart, int rightEnd){
        // Midpoint is where the left ends
        int leftEnd = leftStart + (rightEnd-leftStart) /2;
        // Midpoint + 1 is where the right starts
        int rightStart = leftEnd + 1;

        // Size is useful for copying arrays
        int size = rightEnd - leftStart + 1;

        // Initialize pointers, we need one for left, right, and index of the temp array
        // e.g.
        // [1,4,6,9]  & [2,5,7,10]
        //  ^left        ^right
        // tmp = [0,0,0,0,0,0,0]
        //        ^index
        //
        int curLeft = leftStart;
        int curRight = rightStart;
        int index = leftStart;

        // "merge" both left and right arrays into tmp array
        while(curLeft <= leftEnd && curRight <= rightEnd){
            if(array[curLeft] <= array[curRight]){
                tmp[index] = array[curLeft];
                curLeft++;
            }else{
                tmp[index] = array[curRight];
                curRight++;
            }
            index++;
        }

        // Add the remaining arrays if one got emptied first
        while(curLeft <= leftEnd){
            tmp[index] = array[curLeft];
            curLeft++;
            index++;
        }
        while(curRight <= rightEnd){
            tmp[index] = array[curRight];
            curRight++;
            index++;
        }

        // Copy the tmp array into the source array
        System.arraycopy(tmp, leftStart, array, leftStart, size);
    }
}
