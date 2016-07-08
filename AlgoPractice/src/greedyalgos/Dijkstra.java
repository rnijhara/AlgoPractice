package greedyalgos;

/*
Dijkstra’s algorithm is very similar to Prim’s algorithm for minimum spanning tree. 
Like Prim’s MST, we generate a SPT (shortest path tree) with given source as root. 
We maintain two sets, one set contains vertices included in shortest path tree, 
other set includes vertices not yet included in shortest path tree. 
At every step of the algorithm, we find a vertex which is in the other set 
(set of not yet included) and has minimum distance from source.

Below are the detailed steps used in Dijkstra’s algorithm 
to find the shortest path from a single source vertex to all other vertices in the given graph.
Algorithm:
1) Create a set sptSet (shortest path tree set) that keeps track of vertices 
   included in shortest path tree, i.e., whose minimum distance from source is calculated and finalized. 
   Initially, this set is empty.
2) Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE. Assign distance value as 0 for the source vertex so that it is picked first.
3) While sptSet doesn’t include all vertices
    a) Pick a vertex u which is not there in sptSet and has minimum distance value.
    b) Include u to sptSet.
    c) Update distance value of all adjacent vertices of u. 
       To update the distance values, iterate through all adjacent vertices. 
       For every adjacent vertex v, if sum of distance value of u (from source) and weight of edge u-v, is less than the distance value of v, then update the distance value of v.
*/

class Dijkstra {

    static int minDistance(int dist[], boolean sptSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!sptSet[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void printSPT(int dist[]) {
        System.out.println("Edge   Distance");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " - " + dist[i]);
        }
    }

    static void dijkstra(int graph[][]) {
        int V = graph.length;
        int dist[] = new int[V];
        boolean sptSet[] = new boolean[V];
        for (int i = 1; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        for (int i = 0; i < V-1; i++) {
            int x = minDistance(dist, sptSet);
            sptSet[x] = true;
            for (int y = 0; y < V; y++) {
                if (graph[x][y] != 0 && !sptSet[y] && dist[x] != Integer.MAX_VALUE 
                        && dist[x]+graph[x][y] < dist[y]) {
                    dist[y] = graph[x][y] + dist[x];
                }
            }
        }
        printSPT(dist);
    }
    
    public static void main(String[] args) {
        int graph[][] = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 0, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 14, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
                                 };
 
        
        dijkstra(graph);
    }
}
