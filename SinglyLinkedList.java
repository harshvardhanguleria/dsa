import java.util.Scanner;

public class SinglyLinkedList {

    private static Scanner sc = new Scanner(System.in);

    private static void menu() {
        System.out.print("\n1. Insert into the linked list"+
                            "\n2. Delete node from the linked list"+
                            "\n3. View the linked list"+
                            "\n4. Reverse the linked list"+
                            "\n5. Exit"+
                            "\nEnter your choice: ");
    }

    // Main function
    public static void main(String[] args) {
        System.out.println("Singly Linked List implementation in Java");
        boolean exit = false;
        int choice;
        while (!exit) {
            menu();
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("\nWrong choice\n");
            }
        }
    }
}