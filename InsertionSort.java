public class InsertionSort {

    private static void insertionSort(int[] list) {
        int[] used = new int[list.length];
        int element = 0, j = 0, c = 0;
        int p = 0, m = 0, comp = 0;
        int s = 0, ins = 0;
        for (int i = 1; i < list.length; i++) {
            element = list[i];
            used[c++] = element;
            j = i - 1;
            while ((j > -1) && (list[j] > element)) {
                list[j + 1] = list[j];
                j--;
                ++m; // movement
            }
            list[j + 1] = element;
            ins++; // insertion
            p++; // passthrough
        }
        display(list, p, m, comp, s, ins);
    }

    private static void display(int[] list, int p, int m,
                                int comp, int s, int ins) {
        System.out.println();
        for (int i : list) {
            System.out.print(i +" ");
        }
        System.out.println("\n\nPassthrough - "+ p +"\nMovement - "+ m +
                            "\nComparison - "+ comp +"\nSelection - "+ s +
                            "\nInsertion - "+ ins +"\n");
    }

    public static void main(String[] args) {
        int[][] listArray = {
            {30,25,16,80,85,2},
            {10,9,8,7,6,5,4,3,2,1},
            {100,105,110,120,125}
        };
        for (int[] i : listArray) 
            insertionSort(i);
    }
}