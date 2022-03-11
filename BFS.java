import java.util.Scanner;
import java.util.LinkedList;

public class BFS {

    private static LinkedList<String> list[];
    private static int vertices;

    BFS(int vertices) { // Creating a new linked list
        this.vertices = vertices;
        list = new LinkedList[vertices];

        for (int i = 0; i < vertices; ++i)
            list[i] = new LinkedList<>();
    }

    private static BreadthFirstSearch(String s) {
        boolean visited[] = new boolean[vertices];

        LinkedList<String> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

    } 

    public static void main(String[] args) {

    }
}