import java.util.Arrays;

public class InsertionSort {

    private static void iterative(int[] list) {
        int element = 0, j = 0, c = 0;
        int p = 0, m = 0, comp = 0;
        int s = 0, ins = 0;
        
        for (int i = 1; i < list.length; i++) {
            element = list[i];
            ++s; // selection
            j = i - 1;
            while ((j > -1) && (list[j] > element)) {
                ++comp; // comparison
                list[j + 1] = list[j];
                j--;
                ++m; // movement
            }
            list[j + 1] = element;
            ++ins; // insertion
            p++; // passthrough
        }
        display(list, p, m, comp, s, ins);
    }

    private static void recursive(int[] list, int n) {
        if (n <= 1)
            return;
        recursive(list, n - 1);
        int last = list[n - 1];
        int j = n - 2;
        while (j >= 0 && list[j] > last) {
            list[j + 1] = list[j];
            j--;
        }
        list[j + 1] = last;
    }

    private static void display(int[] list, int p, int m,
                                int comp, int s, int ins) {
        System.out.println(Arrays.toString(list));
        System.out.println("\nPassthrough - "+ p +"\nMovement - "+ m +
                            "\nComparison - "+ comp +"\nSelection - "+ s +
                            "\nInsertion - "+ ins +"\n");
    }

    public static void main(String[] args) {
        int[][] iterativeInput = {
            {30,25,16,80,85,2},
            {10,9,8,7,6,5,4,3,2,1},
            {100,105,110,120,125}
        };

        int[][] recursiveInput = {
            {30,25,16,80,85,2},
            {10,9,8,7,6,5,4,3,2,1},
            {100,105,110,120,125}
        };

        System.out.println("\nOriginal arrays\n");
        for (int[] i : recursiveInput)
            System.out.println(Arrays.toString(i));
        
        System.out.println("\nIterative approach\n");
        for (int[] i : iterativeInput) 
            iterative(i);
        
        System.out.println("\nRecursive approach\n");
        for (int[] i : recursiveInput)
            recursive(i, i.length);
        
        for (int[] i : recursiveInput)
            System.out.println(Arrays.toString(i));
    }
}