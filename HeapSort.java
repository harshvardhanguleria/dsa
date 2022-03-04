import java.util.Arrays;

public class HeapSort
{
    
    private static void swap(int i, int j) {
        int temp = i; 
        i = j; 
        j = temp;
    }
    
    private static void sort(int array[]) {
        int n = array.length;
        for (int i = n/2 - i; i >= 0; i--)
            heapify(array, n, i);
        for (int i = n - 1; i >= 0; i--) {
            swap(array[0], array[i]);
            heapify(array, i, 0);
        }
    }
    
    private static void heapify(int  array[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && array[left] > array[largest])
            largest = left;
        if (right < n && array[right] > array[largest])
            largest = right;
        if (largest != i) {
            swap(array[i], array[largest]);
            heapify(array, n, largest);
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
            sort(i);
        System.out.println("\nThe sorted arrays are:"); 
        for (int[] i : input)
            System.out.println(Arrays.toString(i)); 
	}
}
