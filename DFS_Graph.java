import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS_Graph {
    private LinkedList<Integer> adj[];
    private boolean visited[];

    DFS_Graph(int v) {
        adj =  new LinkedList[v];
        visited = new boolean[v];

        for (int i =0; i < v; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    private void insertEdge(int source, int destination) {
        adj[source].add(destination);
    }

    private void DFS(int vertex) {
        visited[vertex] = true;

        System.out.print(vertex +" ");

        Iterator<Integer> it = adj[vertex].listIterator();

        while (it.hasNext()) {
            int n = it.next();

            if (!visited[n])
                DFS(n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfNodes;
        int source, destination;
        int nodeToSearchFor;

        System.out.print("\nEnter number of nodes: ");
        numberOfNodes = sc.nextInt();

        DFS_Graph graph = new DFS_Graph(numberOfNodes);

        while (true) {
            System.out.println("\nEnter -1 to stop");

            System.out.print("\nEnter source: ");
            source = sc.nextInt();

            if (source == -1)
                break;

            System.out.print("\nEnter destination: ");
            destination = sc.nextInt();
            
            graph.insertEdge(source, destination);
        }

        System.out.print("\nEnter the element from which you want to start the traversal: ");
        nodeToSearchFor = sc.nextInt();

        sc.close();

        System.out.print("\nBreadth First Search traversal for the graph is: ");
        
        graph.DFS(nodeToSearchFor);

        /*
        graph.insertEdge(0, 1);    
        graph.insertEdge(0, 2);    
        graph.insertEdge(0, 3);    
        graph.insertEdge(1, 3);    
        graph.insertEdge(2, 4);  
        graph.insertEdge(3, 5);       
        graph.insertEdge(3, 6);    
        graph.insertEdge(4, 7);    
        graph.insertEdge(4, 5);    
        graph.insertEdge(5, 2); 

        graph.DFS(0);

        0 1 3 5 2 4 7 6
        */
    }
}
