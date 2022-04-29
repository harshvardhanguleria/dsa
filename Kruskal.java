import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kruskal {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        // Adding the edges
        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge); // add to total edges
        }

        public void kruskal() {
            PriorityQueue<Edge> pq = new PriorityQueue<>(
                allEdges.size(),
                Comparator.comparingInt(o -> o.weight)
            );

            // add all the edges to the priority queue
            // sort the edges on weights
            for (int i = 0; i < allEdges.size(); ++i)
                pq.add(allEdges.get(i));

            int[] parent = new int[vertices];

            makeSet(parent);

            ArrayList<Edge> mst = new ArrayList<>();

            int index = 0;
            while (index < vertices - 1) {
                Edge edge = pq.remove();

                // check if adding this edge creates a cycle
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);

                if (x_set != y_set) {
                    // add to the final result
                    mst.add(edge);
                    index++;
                    union(parent, x_set, y_set);
                }
            }

            // Print MST
            System.out.println("\nMinimum Spanning Tree:");
            printGraph(mst);
        }

        public void makeSet(int[] parent) {
            // Make a set creating a new element with a parent pointer 
            // to itself
            for (int i = 0; i < vertices; ++i)
                parent[i] = i;
        }

        public int find(int[] parent, int vertex) {
            // Chain of parent pointer from x upwards through the tree
            // until an element is reached whose parent is itself
            if (parent[vertex] != vertex)
                return find(parent, parent[vertex]);
            
            return vertex;
        }

        public void union(int[] parent, int x, int y) {
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);

            // make x as parent of y
            parent[y_set_parent] = x_set_parent;
        }

        public void printGraph(ArrayList<Edge> edgeList) {
            System.out.println("Edge  Source  Destination  Weight");
            int totalCost = 0;
            for (int i = 0; i < edgeList.size(); ++i) {
                Edge edge = edgeList.get(i);
                System.out.println("  "+ i +" -> \t"+
                                    edge.source +"\t   "+
                                    edge.destination +"\t     "+
                                    edge.weight);
                totalCost = totalCost + edge.weight;
            }
            System.out.println("\nThe total cost = "+ totalCost);
        }
    }

    public static void main(String[] args) {
        /*
        vertices = 6

        0, 1, 4
        0, 2, 3
        1, 2, 1
        1, 3, 2
        2, 3, 4
        3, 4, 2
        4, 5, 6
        */
        Scanner sc = new Scanner(System.in);
        int vertices;
        int src, dest, weight;

        System.out.print("\nEnter number of vertices: ");
        vertices = sc.nextInt();

        Graph g = new Graph(vertices);
        
        System.out.println("\nEnter source, destination and weight");
        while (true) {
            System.out.println("\nEnter -1 to stop");
            System.out.print("\nSource: ");
            src = sc.nextInt();
            
            if (src == -1)
                break;

            System.out.print("Destination: ");
            dest = sc.nextInt();
            System.out.print("Weight: ");
            weight = sc.nextInt();

            g.addEdge(src, dest, weight);
        }

        sc.close();

        g.kruskal();
    }
}