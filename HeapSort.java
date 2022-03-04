import java.util.Arrays;
import java.util.Scanner;

public class HeapSort
{

    private static int iteration = 0;
    
    private static void swap(int array[], int i, int j) {
        int temp = array[i]; 
        array[i] = array[j]; 
        array[j] = temp;
    }
    
    private static void sort(int array[]) {
        int n = array.length;
        for (int i = n/2 - 1; i >= 0; i--) 
            heapify(array, n, i);
        for (int i = n - 1; i >= 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }
    
    private static void heapify(int  array[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        iteration++;
        if (left < n && array[left] > array[largest])
            largest = left;
        if (right < n && array[right] > array[largest])
            largest = right;
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }
    
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("\nEnter length of the array: ");
        n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("\nEnter the numbers in the array: ");
        for (int i = 0; i < n; ++i) 
            array[i] = sc.nextInt();
        sc.close();
        System.out.println("\nThe Original array is");
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println("\nThe sorted array is");
        System.out.println(Arrays.toString(array));
        System.out.println(iteration +" iterations were used to sort the array.");
		/*int[][] input = {
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
            System.out.println(Arrays.toString(i)); */
        
	}
}