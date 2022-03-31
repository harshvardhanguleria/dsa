import java.util.Scanner;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Comparator;

class Node {
    protected static int destination;
    protected static int weight;
    
    Node (int a, int b) {
        this.destination = a;
        this.weight = b;
    }
}

class Graph {
    protected static int V;
    protected static LinkedList<Node>[] adj;

    Graph(int e) {
        this.V = e;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) 
            adj[i]= new LinkedList<>();
    }
}

// Class to represent a node in priority queue
class Node1 {
    protected static int vertex;
    protected static int key;
}

// Comparator class for priority queue
// returns 1 if node0.key > node1.key
// returns 0 if node0.key < node1.key
// returns -1 otherwise
class comparator implements Comparator<Node1> {
    
    @Override
    public int compare(Node1 node0, Node1 node1) {
        return node0.key - node1.key;
    }
}

public class PrimsAlgo {

    // Adding edge between two vertices
    private static void addEdge(Graph graph, int source, int destination,
                                int weight) {
        Node node0 = new Node(destination, weight);
        Node node = new Node(source, weight);
        graph.adj[source].addLast(node0);
        graph.adj[destination].addLast(node);
    }

    // Finding the MST
    private static void mst(Graph graph) {
        
        // Whether the vertex is a priority queue or not
        Boolean[] mstSet = new Boolean[graph.V];
        Node1[] e = new Node1[graph.V];

        // Stores the parents of a vertex
        int[] parent = new int[graph.V];

        for (int i = 0; i < graph.V; ++i)
            e[i] = new Node1();

        for (int i = 0; i < graph.V; ++i) {

            // Initialize to false
            mstSet[i] = false;

            // Initialize key values to infinity
            e[i].key = Integer.MAX_VALUE;
            e[i].vertex = i;
            parent[i] = -1;
        }

        // Include the source vertex in mstSet
        mstSet[0] = true;

        // Set key value to 0
        // so that it is extracted first out of
        // Priority Queue
        e[0].key = 0;

        // use tree set instead of Priority queue as the remove 
        // function
        TreeSet<Node1> queue = new TreeSet<Node1>(new comparator());

        for (int i = 0; i < graph.V; ++i) 
            queue.add(e[i]);

        // Loop until the queue is not empty
        while (!queue.isEmpty()) {

            // Extracts a node with min key value
            Node1 node0 = queue.pollFirst();

            // Include that node to the mstSet
            mstSet[node0.vertex] = true;

            // For all adjacent vertex of the extracted vertex V
            for (Node iterator : graph.adj[node0.vertex]) {

                // If V is in queue
                if (mstSet[iterator.destination] == false) {
                    
                    // If the key value of the adjacent vertex is more
                    // than the extracted key, update the key value
                    // of the adjacent vertexx.
                    // To update first remove and add the updated
                    // vertex
                    if (e[iterator.destination].key > iterator.weight) {
                        queue.remove(e[iterator.destination]);
                        e[iterator.destination].key = iterator.weight;
                        queue.add(e[iterator.destination]);
                        parent[iterator.destination] = node0.vertex;
                    }
                }
            }
        }

        // Print the vertex pairs of MST
        System.out.println("\nThe Minimum Spanning Tree is");
        for (int i = 1; i < graph.V; ++i) 
            System.out.println(parent[i] +" - "+ i);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int V;
        int source, destination, weight;
        Boolean exit = false;

        System.out.print("\nEnter the number of vertices: ");
        V = sc.nextInt();

        // Creating the graph
        Graph graph = new Graph(V);

        while (!exit) {
            System.out.println("\nEnter -1 to stop.");
            System.out.print("\nEnter source: ");
            source = sc.nextInt();
            System.out.print("\nEnter destination: ");
            destination = sc.nextInt();
            System.out.print("\nEnter weight: ");
            weight = sc.nextInt();
        
            // calling the function to add the edges
            addEdge(graph, source, destination, weight);
        }

        // Calling the MST function
        mst(graph);
    }
}