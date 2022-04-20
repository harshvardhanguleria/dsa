import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.DialogTypeSelection;

import java.util.Comparator;
import java.util.HashSet;

class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node () {}
    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        
        return 0;
    }
}

public class Dijkstra {

    private int distance[];
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private int vertices;
    List<List<Node>> adj;

    public Dijkstra(int v) {
        this.vertices = v;
        distance = new int[v];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(v, new Node());
    }

    public void dijkstra(List<List<Node>> adj, int src) {
        this.adj = adj;

        for (int i = 0; i < vertices; ++i)
        distance[i] = Integer.MAX_VALUE;

        // adding source node to the priority queue
        pq.add(new Node(src, 0));

        distance[src] = 0;

        while (settled.size() != vertices) {
            if (pq.isEmpty())
                return;

            // Removing the min distance node from the priority queue
            int u = pq.remove().node;

            // Adding the node whose distance is finalized
            if (settled.contains(u))
                continue;

            settled.add(u);

            neighbours(u);
        }
    }

    private void neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;

        // All neighbours of vertex
        for (int i = 0; i < adj.get(u).size(); ++i) {
            Node v = adj.get(u).get(i);

            // If the current node is not already processed
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = distance[u] + edgeDistance;

                // If new distance is cheaper
                if (newDistance < distance[v.node])
                    distance[v.node] = newDistance;

                // Add the current node to the queue
                pq.add(new Node(v.node, distance[v.node]));
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
