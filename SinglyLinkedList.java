import java.util.Scanner;

class Node {
    protected int data;
    protected Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class SLL {
    private Node head;

    SLL() {
        this.head = null;
    }

    // inserting a node at the end of the list
    public void insertEnd(Node newNode) {
        Node lastNode;
        if (this.head == null) 
            this.head = newNode;
        else {
            lastNode = this.head;
            while (lastNode.next != null) 
                lastNode = lastNode.next;
            lastNode.next = newNode;
        }
        System.out.println("\nNode inserted");
    }   

    // inserting a node at the beginning of the list
    public void insertBeginning(Node newNode) {
        if (this.head == null)
            this.head = newNode;
        else {
            newNode.next = this.head;
            this.head = newNode;
        }
        System.out.println("\nNode inserted");
    }

    // inserting a node at a specific position in the list
    public void insertPosition(Node newNode, int position) {
        int count = 0;
        Node firstNode = null; 
        Node currentNode = null; 
        Node previousNode = null;
        if (this.head == null) 
            this.head = newNode;
        else if (position == 0) {
            firstNode = newNode;
            firstNode.next = this.head;
            this.head = firstNode;
        } else {
            currentNode = this.head;
            while (true) {
                if (count == position) {
                    previousNode.next = newNode;
                    newNode.next = currentNode;
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
                count = count + 1;
            }
        }
        System.out.println("\nNode inserted");
    }

    // deleting a node from the end of the list
    public void deleteEnd() {
        Node lastNode;
        if (this.head == null) {
            System.out.println("\nThe list is empty");
            return;
        }
        lastNode = this.head;
        while (lastNode.next.next != null)
            lastNode = lastNode.next;
        System.out.println("\nDeleted "+ lastNode.data);
        lastNode.next = null;
    }

    // deleting a node from the beginning of the list
    public void deleteBeginning() {
        Node firstNode;
        if (this.head == null) {
            System.out.println("\nThe list is empty");
            return;
        }
        firstNode = this.head;
        this.head = firstNode.next;
        System.out.println("\nDeleted "+ firstNode.data);
        firstNode = null;
    }

    // deleting a node from any position in the list
    public void deletePosition(int position) {
        Node currentNode = null;
        Node previousNode = null;
        int count = 0;
        if (this.head == null) {
            System.out.println("\nThe list is empty");
            return;
        }
        currentNode = this.head;
        while (true) {
            if (position == 0) {
                this.head = currentNode.next;
                break;
            } else if (count == position) {
                previousNode.next = currentNode.next;
                break;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
            count = count + 1;
        }
        System.out.println("\nDeleted "+ currentNode.data);
        currentNode = null;
    }

    // reversing the linked list
    public void reverseList() {
        Node currentNode, previousNode, nextNode;
        if (this.head == null) {
            System.out.println("\nThe list is empty");
            return;
        }
        currentNode = this.head;
        previousNode = null;
        nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        this.head = previousNode;
        System.out.println("\nThe list has been reversed");
        displayList();
    }

    // Display the list
    public void displayList() {
        Node currentNode = null;
        if (this.head == null) {
            System.out.println("\nThe list is empty");
            return;
        }
        currentNode = this.head;
        while (true) {
            if (currentNode == null) {
                System.out.println("null");
                break;
            }
            System.out.print(currentNode.data +" -> ");
            currentNode = currentNode.next;
        }
    }
}

public class SinglyLinkedList {

    private static void menu(int choice) {
        if (choice == 1) {
            System.out.print("\n1. Insert into the linked list"+
                                "\n2. Delete node from the linked list"+
                                "\n3. View the linked list"+
                                "\n4. Reverse the linked list"+
                                "\n5. Exit"+
                                "\nEnter your choice: ");
        } else if (choice == 2) {
            System.out.print("\n1. Insert in the end"+
                                "\n2. Insert in the beginning"+
                                "\n3. Insert at a specific position"+
                                "\nEnter your choice: ");
        } else if (choice == 3) {
            System.out.print("\n1. Delete at the end"+
                                "\n2. Delete from the beginning"+
                                "\n3. Delete from a specific position"+
                                "\nEnter your choice: ");
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL sll = new SLL();
        System.out.println("Singly Linked List implementation in Java");
        boolean exit = false;
        int choice, data, ch, position;
        while (!exit) {
            menu(1);
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("\nEnter the integer value to be inserted: ");
                    data = sc.nextInt();
                    Node newNode = new Node(data);
                    menu(2);
                    ch = sc.nextInt();
                    switch(ch) {
                        case 1:
                            sll.insertEnd(newNode);
                            break;
                        case 2:
                            sll.insertBeginning(newNode);
                            break;
                        case 3:
                            System.out.print("\nEnter the position: ");
                            position = sc.nextInt();
                            sll.insertPosition(newNode, position);
                        default:
                            System.out.println("\nWrong choice");
                    }
                    break;
                case 2:
                    menu(3);
                    ch = sc.nextInt();
                    switch(ch) {
                        case 1:
                            sll.deleteEnd();
                            break;
                        case 2:
                            sll.deleteBeginning();
                            break;
                        case 3:
                            System.out.print("\nEnter the position: ");
                            position = sc.nextInt();
                            sll.deletePosition(position);
                            break;
                        default:
                            System.out.println("\nWrong choice");
                    }
                    break;
                case 3:
                    sll.displayList();
                    break;
                case 4:
                    sll.reverseList();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("\nWrong choice\n");
            }
        }
        sc.close();
    }
}