package sortingalgorithms;
// Author: Christopher Dip
// Date: 08-25-2021
// MIT License
// Coding practice for DSA
// Time complexity of bubble sort is:
// Ω(n) at best
// O(n^2) on average
// O(n^2) at worst
// Space complexity of bubble sort is:
// O(1) we do not need an extra data structure to sort

public class BubbleSort extends SortingAlgorithm {
    public static void sort(int[] array){
        boolean isSorted = false;
        // Since we bubble the maximum value to the end of the array
        // The last value is always sorted after each pass
        // And we can decrement the sorting bound by one everytime
        int sortingBound = array.length-1;
        // If we never hit the if condition, it means it is sorted and we break from the while loop
        while(!isSorted){
            isSorted = true;
            for(int i = 0; i < sortingBound; i++){
                if(array[i+1] < array[i]){
                    swap(array, i, i+1);
                    isSorted = false;
                }
            }
            sortingBound--;
        }
    }


}
