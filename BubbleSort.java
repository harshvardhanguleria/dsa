import java.util.Scanner;
import java.util.ArrayList;

public class BubbleSort {

    private static ArrayList<Integer> list = new ArrayList<>();

    private static void display() {
        for (Integer a : list) {
            if (a == -1)
                break;
            System.out.println(a);
        }
    }

    private static void bubbleSort() {
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        while (a != -1) {
            System.out.println("\nEnter -1 to stop entering numbers into the array list.");
            a = sc.nextInt();
            list.add(a);
        }
        display();
        //bubbleSort();
        //display();
    }
}
