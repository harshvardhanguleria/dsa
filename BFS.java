import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Stack;

class Node {

    protected char data;
    protected Node left;
    protected Node right;

    Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {

    private static Node root;

    Tree() {
        this.root = null;
    }

    private static Node insert(Node current, char data) {
        
        if (current == null)
            return new Node(data);
        if ((int)data < (int)current.data)
            current.left = insert(current.left, data);
        else if ((int)data > (int)current.data)
            current.right =insert(current.right, data);
        else 
            return current;
        
        return current;
    }

    public static void add(char data) {
        root = insert(root, data);
    }

    public static Tree createTree() {
        Tree t = new Tree();

        Scanner sc = new Scanner(System.in);
        char input;
        char ch;

        do {    
            System.out.print("\nEnter the element: ");
            input = sc.next().charAt(0);
            t.add(input);
            System.out.print("\nDo you want to continue(y/n): ");
            ch = sc.next().charAt(0);

        } while(ch == 'y' || ch == 'Y');

        sc.close();
        System.out.print("\nThe tree is ");
        inorderTraversal(t.root);

        return t;
    }

    public static void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(" "+ node.data);
            inorderTraversal(node.right);
        }
    }

    public static void BFS(char element) {
        if (root == null)
            return;
        
        Queue<Node> nodes = new LinkedList<>();
        ArrayList<Character> list = new ArrayList<>(); 
        nodes.add(root);
        int flag = 0;

        while(!nodes.isEmpty()) {
            Node node = nodes.remove();

            if (node.data == element)
                break;

            if (node.data != element)
                flag = -1;
            else 
                flag = 0;

            list.add(node.data);

            if (node.left != null)
                nodes.add(node.left);
            
            if (node.right != null)
                nodes.add(node.right);
        }

        if (flag == -1)
            System.out.println("\nThe element is not present in the tree.");
        else    
            System.out.println("\nThe path followed to find the element is "+
                                list +".");
    }

    public static void DFSInorder(char element) {
        if (root == null) 
            return;
        
        Stack<Node> s = new Stack<Node>();
        ArrayList<Character> list = new ArrayList<>();
        Node current = root;
        int flag = 0;

        while (current != null || s.size() > 0) {

            if (element == current.data)
                break;
            
            if (element != current.data)
                flag = -1;
            else 
                flag = 0;
            
            while (current != null) {
                s.push(current);
                current = current.left;
            }

            current = s.pop();

            list.add(current.data);

            current = current.right;
        }

        if (flag == -1)
            System.out.println("\nThe element is not present in the tree.");
        else    
            System.out.println("\nThe path followed to find the element is "+
                                list +".");
    }
}

public class BFS {

    public static void main(String[] args) {

        Tree tree = new Tree();
        Scanner sc = new Scanner(System.in);

        tree = tree.createTree();

        System.out.print("\nEnter the element to be searched: ");
        char input = sc.next().charAt(0);

        System.out.println("\nBreadth First Search Output");
        tree.BFS(input);

        System.out.println("\nDepth First Search Inorder Output");
        tree.DFSInorder(input);

    }
}