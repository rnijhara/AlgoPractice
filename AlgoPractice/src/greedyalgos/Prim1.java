package greedyalgos;

/*
 Algorithm
 1) Create a set mstSet that keeps track of vertices already included in MST.

 2) Assign a key value to all vertices in the input graph. 
    Initialize all key values as INFINITE. 
    Assign key value as 0 for the first vertex so that it is picked first.

 3) While mstSet doesn’t include all vertices
    a) Pick a vertex u which is not there in mstSet and has minimum key value.
    b) Include u to mstSet.
    c) Update key value of all adjacent vertices of u. 
       To update the key values, iterate through all adjacent vertices. 
       For every adjacent vertex v, if weight of edge u-v is less than the previous key value of v, 
       update the key value as weight of u-v.

 How to implement the above algorithm?
 Use a boolean array mstSet[] to represent the set of vertices included in MST. 
 If a value mstSet[v] is true, then vertex v is included in MST, otherwise not. 
 Array key[] is used to store key values of all vertices. 
 Another array parent[] to store indexes of parent nodes in MST. 
 The parent array is the output array which is used to show the constructed MST.

Time Complexity of the program is O(V^2). 
If the input graph is represented using adjacency list, 
then the time complexity of Prim’s algorithm can be reduced to O(E log V) 
with the help of binary heap. 
 */
class Prim1 {

    static int extractMin(int key[], boolean mst[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < key.length; i++) {
            if (!mst[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void printMST(int parent[], int graph[][]) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < parent.length; i++) { // Start from 1 coz parent[0]=-1
            System.out.println(parent[i] + " - " + i + "    "
                    + graph[i][parent[i]]);
        }
    }

    static void primMst(int graph[][]) {
        int V = graph.length;
        int key[] = new int[V];
        boolean mst[] = new boolean[V];
        int parent[] = new int[V];
        for (int i = 1; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
        }
        parent[0] = -1;
        for (int i = 0; i < V; i++) {
            int x = extractMin(key, mst);
            mst[x] = true;
            for (int y = 0; y < V; y++) {
                if (graph[x][y] != 0 && !mst[y] && graph[x][y] < key[y]) {
                    key[y] = graph[x][y];
                    parent[y] = x;
                }
            }
        }
        printMST(parent, graph);
    }
    
    public static void main(String[] args) {
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0},
                                   };
 
        
        primMst(graph);
    }
}
