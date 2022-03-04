import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j <= high; ++j) {
            if (array[j] <= pivot) {
                i++;
                // Comparing with pivot element
                // and swapping, if needed.
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // swapping with the pivot
        // to ensure that the pivot is in 
        // its correct place.
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return (i + 1);
    }

    private static void sort(int[] array, int low, int high) {
        if (low < high) {
            int index = partition(array, low, high);
            sort(array, low, index - 1);
            sort(array, index + 1, high);
        }
    }
    
    public static void main(String[] args) {
        int[][] input = {
            {30,25,16,80,85,2},
            {10,9,8,7,6,5,4,3,2,1},
            {100,105,110,120,125}
        };
        System.out.println("\nThe orriginal arrays are: ");
        for (int[] i : input)
            System.out.println(Arrays.toString(i));
        for (int[] i : input) 
            sort(i, 0, i.length - 1);
        System.out.println("\nThe sorted arrays are:"); 
        for (int[] i : input)
            System.out.println(Arrays.toString(i));    
    }
}