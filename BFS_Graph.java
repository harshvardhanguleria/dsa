import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Graph {

    // total number of nodes in the graph
    private int node;

    // adjacency list
    private LinkedList<Integer> adj[];
    
    // maintaining a queue of nodes in the graph
    private static Queue<Integer> que;

    BFS_Graph(int v) {
        this.node = v;
        this.adj = new LinkedList[node];

        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
        
        que = new LinkedList<Integer>();
    }

    private void insertEdge(int v, int w) {
        // adding an edge into the adjacency list
        adj[v].add(w);
    }

    private void BFS(int n) {
        // boolean to hold the data
        boolean nodes[] = new boolean[node];

        int a = 0;
        nodes[n] = true;
        que.add(n); // root node

        while (que.size() != 0) {
            // remove the top element
            n = que.poll();

            // Printing the top element of the queue
            System.out.print(n +" "); 

            // iterating through all list and pushing all the neighbours 
            // into the queue
            for (int i = 0; i < adj[n].size(); ++i) {
                a = adj[n].get(i);
                
                // inserting nodes if they are not already in the queue
                if (!nodes[a]) {
                    nodes[a] = true;
                    que.add(a);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfNodes;
        int source, destination;
        int nodeToSearchFor;

        System.out.print("\nEnter number of nodes: ");
        numberOfNodes = sc.nextInt();

        BFS_Graph graph = new BFS_Graph(numberOfNodes);

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

        System.out.print("\nEnter the element you want to search: ");
        nodeToSearchFor = sc.nextInt();

        sc.close();

        System.out.print("\nBreadth First Search traversal for the graph is: ");
        
        graph.BFS(nodeToSearchFor);
    }
}
