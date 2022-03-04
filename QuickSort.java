import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    private static int iteration = 0;

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];      
        System.out.println("\nPivot: "+ pivot);
        System.out.println(Arrays.toString(array));
        int i = low - 1;
        for (int j = low; j <= high - 1; ++j) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
            iteration++;
        }
        swap(array, i + 1, high);
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
        sort(array, 0, n - 1);
        System.out.println("\nThe sorted array is");
        System.out.println(Arrays.toString(array));
        System.out.println(iteration +" iterations were used to sort the array.");
            /*
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
            System.out.println(Arrays.toString(i)); */   
    }
}