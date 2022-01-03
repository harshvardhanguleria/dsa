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
        
    }
}

public class DoublyLinkedList {
    
}
