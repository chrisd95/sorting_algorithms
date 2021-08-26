import sortingalgorithms.BubbleSort;
import sortingalgorithms.MergeSort;
import sortingalgorithms.QuickSort;
import java.util.Arrays;

public class SortingApp {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        int[] testArray = new int[] {4,5,1,2,3,5,7,73,2,3,4,-1,3,-2,3,-49,44,333,22,11};
        MergeSort.sort(testArray);
        final long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(testArray));
        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
