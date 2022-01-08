import java.util.Scanner;

class Node {
    protected int data;
    protected Node next;
    protected Node prev;
    
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DLL {
    private Node head;

    DLL() {
        this.head = null;
    }

    // Inserting a node at the end of the list
    public void insertEnd(Node newNode) {
        Node lastNode;
        if (this.head == null)
            this.head = newNode;
        else {
            lastNode = this.head;
            while (lastNode.next != null)
                lastNode = lastNode.next;
            lastNode.next = newNode;
            newNode.prev = lastNode;
        }
        System.out.println("\nNode inserted");
    }

    // Inserting a node at the beginning of the list
    public void insertBeginning(Node newNode) {
        if (this.head == null)
            this.head = newNode;
        else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        System.out.println("\nNode inserted");
    }

    // Inserting a node at a specific position in the list
    public void insertPosition(Node newNode, int position) {
        int count = 0;
        Node currentNode = null;
        Node previousNode = null;
        if (this.head == null)
            this.head = newNode;
        else if (position == 0) {
            newNode.next = this.head;
            this.head = newNode;
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
    }

    // Deleting a node from the end of the list
    public void deleteEnd() {
        Node lastNode;
        if (this.head == null) {
            System.out.println("\nThe list is empty.");
            return;
        }
        lastNode = this.head;
        while (lastNode.next.next != null)
            lastNode = lastNode.next;
        System.out.println("\nDeleted "+ lastNode.data);
        lastNode.next = null;
    }
}

public class DoublyLinkedList {
    
}
