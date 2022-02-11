import java.util.Arrays;

public class MergeSortIterative {

    private static int[] op = {0, 0, 0};

    private static void mergeSort(int[] list, int op) {
        if (list == null)
            return;
        if (list.length > 1) {
            int mid = list.length / 2;

            int[] left = new int[mid];
            for (int i = 0; i < mid; ++i) {
                left[i] = list[i];
                op++;
            }

            int[] right = new int[list.length - mid];
            for (int i = mid; i < list.length; ++i) {
                right[i - mid] = list[i];
                op++;
            }
            
            mergeSort(left, op);
            mergeSort(right, op);

            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    list[k] = left[i];
                    i++;
                    op++;
                } else {
                    list[k] = right[j];
                    j++;
                    op++;
                }
                k++;
            }

            while (i < left.length) {
                list[k] = left[i];
                i++;
                k++;
                op++;
            }

            while (j < right.length) {
                list[k] = right[j];
                j++;
                k++;
                op++;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] iterativeInput = {
            {30,25,16,80,85,2},
            {10,9,8,7,6,5,4,3,2,1},
            {100,105,110,120,125}
        };
        int a = 0;
        System.out.println("\nOriginal arrays\n");
        for (int[] i : iterativeInput)
            System.out.println(Arrays.toString(i));

        System.out.println("\nIterative approach\n");
        for (int[] i : iterativeInput)
            mergeSort(i, op[a++]);
        for (int[] i : iterativeInput)
            System.out.println(Arrays.toString(i));
        System.out.println("\nTotal number of operations: "+ Arrays.toString(op));
    }
}
