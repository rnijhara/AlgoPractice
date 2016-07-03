package greedyalgos;

import java.util.*;
/*
 Steps:
 1. Sort all the edges in non-decreasing order of their weight.

 2. Pick the smallest edge. Check if it forms a cycle with the spanning tree 
 formed so far. If cycle is not formed, include this edge. Else, discard it.  

 3. Repeat step#2 until there are (V-1) edges in the spanning tree.
 */

class Graph {

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        @Override
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    class Subset {
        int parent, rank;
    }

    int V, E;
    Edge edges[];

    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        this.edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            this.edges[i] = new Edge();
        }
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    void union(Subset subsets[], int i, int j) {
        int iRep = find(subsets, i);
        int jRep = find(subsets, j);

        if (iRep == jRep) {
            return;
        }

        if (subsets[iRep].rank < subsets[jRep].rank) {
            subsets[iRep].parent = jRep;
        } else if (subsets[jRep].rank < subsets[iRep].rank) {
            subsets[jRep].parent = iRep;
        } else {
            subsets[jRep].parent = iRep;
            subsets[iRep].rank++;
        }
    }

    void kruskalMst() {
        Edge mst[] = new Edge[V - 1];
        Subset subsets[] = new Subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }
        Arrays.sort(edges);
        for (int i = 0, e = 0; i < E && e < V-1; i++) {
            Edge edge = edges[i];
            int sRep = find(subsets, edge.src);
            int dRep = find(subsets, edge.dest);
            if (sRep != dRep) {
                mst[e] = new Edge();
                mst[e].src = edge.src;
                mst[e].dest = edge.dest;
                mst[e].weight = edge.weight;
                e++;
                union(subsets, sRep, dRep);
            }
        }
        for (int i = 0; i < V-1; ++i)
            System.out.println(mst[i].src+" -- "+mst[i].dest+" == "+
                               mst[i].weight);
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 5;
        Graph graph = new Graph(V, E);

        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = 10;

        // add edge 0-2
        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 6;

        // add edge 0-3
        graph.edges[2].src = 0;
        graph.edges[2].dest = 3;
        graph.edges[2].weight = 5;

        // add edge 1-3
        graph.edges[3].src = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 15;

        // add edge 2-3
        graph.edges[4].src = 2;
        graph.edges[4].dest = 3;
        graph.edges[4].weight = 4;

        graph.kruskalMst();
    }
}
