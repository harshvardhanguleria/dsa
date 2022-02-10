import java.util.Arrays;

public class MergeSort {

    private static int op = 0;

    private static void merge(int[] list, int p, int q, int r) {
        ++op;
        int n1 = q - p + 1;
        int n2 = r - q;
        
        int L[] = new int[n1];
        int M[] = new int[n2];
        
        for (int i = 0; i < n1; ++i)
            L[i] = list[p + i];
        for (int j = 0; j < n2; ++j)
            M[j] = list[q + j + 1];
        
        int i = 0, j = 0, k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                list[k] = L[i];
                i++;
            } else {
                list[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            list[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            list[k] = M[j];
            j++;
            k++;
        }
    }

    private static void sort(int[] list, int l, int r) {
        if (l < r) {
            ++op;
            int m = (l + r) / 2;
            sort(list, l, m);
            sort(list, m + 1, r);
            merge(list, l, m, r);
        }
    }

    public static void main(String[] args) {
        int[][] recursiveInput = {
            {30,25,16,80,85,2},
            {10,9,8,7,6,5,4,3,2,1},
            {100,105,110,120,125}
        };
        
        System.out.println("\nOriginal arrays\n");
        for (int[] i : recursiveInput)
            System.out.println(Arrays.toString(i));

        System.out.println("\nRecursive approach\n");
        for (int[] i : recursiveInput)
            sort(i, 0, i.length - 1);
        for (int[] i : recursiveInput)
            System.out.println(Arrays.toString(i));
        System.out.println("\nTotal number of operations: "+ op);
    }
}
