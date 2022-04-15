import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

class Graph {

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class subset {
        int parent, rank;
    }

    private static int vertices, edges;
    private static Edge edge[];

    // Creating the graph
    Graph(int v, int e) {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }
    
    public void displayGraph() {
        System.out.println("\nOriginal graph");
        System.out.println("\nSource - Destination : Weight");
        for (int i = 0; i < edges; ++i) {
            System.out.println("");
        }
    }

    public void insertEdge(int src, int dest, int weight, int i) {
        edge[i].src = src;
        edge[i].dest = dest;
        edge[i].weight = weight;
    }

    private static int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        
        return subsets[i].parent;
    }

    private static void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // Kruskal Algorithm
    public void Kruskal() {
        Edge result[] = new Edge[vertices];
        int e = 0; 
        
        for (int i = 0; i < vertices; ++i)
            result[i] = new Edge();

        // Sorting the edges
        Arrays.sort(edge);
        subset subsets[] = new subset[vertices];

        for (int i = 0; i < vertices; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        int i = 0;

        while (e < vertices - 1) {
            Edge nextEdge = new Edge();
            nextEdge = edge[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                Union(subsets, x, y);
            }
        }

        System.out.println("\nSource - Destination : Weight");
        for (int j = 0; j < e; ++j)
            System.out.println(result[j].src +" - "+
                                result[j].dest +" : "+
                                result[j].weight);
    }
}

public class KruskalAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices, edges;
        int src, dest, weight;

        System.out.print("\nEnter number of vertices: ");
        vertices = sc.nextInt();
        System.out.print("\nEnter number of edges: ");
        edges = sc.nextInt();

        Graph g = new Graph(vertices, edges);
        
        System.out.println("\nEnter source, destination and weight");
        for (int i = 0; i < edges; ++i) {
            System.out.println("\nEdge "+ (i+1));
            System.out.print("\nSource: ");
            src = sc.nextInt();
            System.out.print("Destination: ");
            dest = sc.nextInt();
            System.out.print("Weight: ");
            weight = sc.nextInt();

            g.insertEdge(src, dest, weight, i);
        }

        g.Kruskal();
        /*
        int vertices = 6; 
        int edges = 8;
        Graph G = new Graph(vertices, edges);      

        G.edge[0].src = 0;
        G.edge[0].dest = 1;
        G.edge[0].weight = 4;

        G.edge[1].src = 0;
        G.edge[1].dest = 2;
        G.edge[1].weight = 4;

        G.edge[2].src = 1;
        G.edge[2].dest = 2;
        G.edge[2].weight = 2;

        G.edge[3].src = 2;
        G.edge[3].dest = 3;
        G.edge[3].weight = 3;

        G.edge[4].src = 2;
        G.edge[4].dest = 5;
        G.edge[4].weight = 2;

        G.edge[5].src = 2;
        G.edge[5].dest = 4;
        G.edge[5].weight = 4;

        G.edge[6].src = 3;
        G.edge[6].dest = 4;
        G.edge[6].weight = 3;

        G.edge[7].src = 5;
        G.edge[7].dest = 4;
        G.edge[7].weight = 3;
        G.KruskalAlgo();
        */
    }
}