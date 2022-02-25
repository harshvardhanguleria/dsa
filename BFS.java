import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Node {
    String data;
    Node left;
    Node right;

    Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    private Node root;

    Tree() {
        this.root = null;
    }

    public void insertNode() {
        Scanner sc = new Scanner(System.in);
        Node newNode;
        Node leftNode;
        Node rightNode;
        Node temp;
        char ch;
        String data;
        do {
            System.out.print("\nEnter the data to be inserted: ");
            data = sc.nextLine();
            temp = this.root;
            newNode = new Node(data);
            if (this.root == null) 
                this.root = newNode;
            else {
                while (temp != null) {

                }
            }
            System.out.print("\nDo you want to enter more(y/n): ");
            ch = sc.next().charAt(0);
        } while (ch == 'y' || ch == 'Y');
    }
}

public class BFS {

    private static List<String> list = new ArrayList<>();

    private static void insertData(String data) {
        list.add(data);
    }
    
    private static void BFS() {

    }

    public static void main(String[] args) {
        
    }
}
