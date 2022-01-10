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
        if (this.head == null)
            this.head = newNode;
        else if (position == 0) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            currentNode = this.head;
            while (count < position) {
                currentNode = currentNode.next;
                count = count + 1;
            }
            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next = newNode;
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

    // Deleting a node from the start of the list
    public void deleteStart() {
        Node firstNode;
        Node secondNode;
        if (this.head == null) {
            System.out.println("\nThe list is empty.");
            return;
        }
        firstNode = this.head;
        secondNode = firstNode.next;
        secondNode.prev = null;
        this.head = secondNode;
        firstNode = null;
    }

    // Deleting a node from a specific position from the list
    public void deletePosition(int position) {
        Node positionNode;
        int count = 0;
        if (this.head == null) {
            System.out.println("\nThe list is empty.");
            return;
        }
        positionNode = this.head;
        while (count < position) {
            positionNode = positionNode.next;
            count = count + 1;
        }
        positionNode.prev.next = positionNode.next;
        positionNode = null;
    }
}

public class DoublyLinkedList {
    
}
