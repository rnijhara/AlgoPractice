package datastructures;

import java.io.*;
/*
1. The union and find operations can be optimized to O(Log n) in worst case. 
The idea is to always attach smaller depth tree under the root of the deeper tree. 
This technique is called union by rank. 
The term rank is preferred instead of height because if path compression technique is used, 
then rank is not always equal to height. 

The above example with union by rank
Initially all elements are single element subsets.
0 1 2 3 

Do Union(0, 1)
   1   2   3  
  /
 0

Do Union(1, 2)
   1    3
 /  \
0    2

Do Union(2, 3)
    1    
 /  |  \
0   2   3


2. The second optimization to naive method is Path Compression. 
The idea is to flatten the tree when find() is called. 
When find() is called for an element x, root of the tree is returned. 
The find() operation traverses up from x to find root. 
The idea of path compression is to make the found root as parent of x
so that we don’t have to traverse all intermediate nodes again. 
If x is root of a subtree, then path (to root) from all nodes under x also compresses.

     
Let the subset {0, 1, .. 9} be represented as below and find() is called
for element 3.
              9
         /    |    \  
        4     5      6
     /     \        /  \
    0        3     7    8
            /  \
           1    2  

When find() is called for 3, we traverse up and find 9 as representative
of this subset. With path compression, we also make 3 as child of 9 so 
that when find() is called next time for 1, 2 or 3, the path to root is 
reduced.

               9
         /    /  \    \
        4    5    6     3 
     /           /  \   /  \
    0           7    8  1   2           

The two techniques complement each other. 
The time complexity of each operations becomes even smaller than O(Logn). 
In fact, amortized time complexity effectively becomes small constant.

Help Links - http://algs4.cs.princeton.edu/15uf/UF.java.html
            http://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
*/


public class DisjointSet2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1[] = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            int parent[] = new int[n + 1];
            int rank[] = new int[n+1];
            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }
            while (m-- > 0) {
                String s2[] = br.readLine().split(" ");
                if (s2[0].equals("F")) {
                    System.out.println(find(parent, Integer.parseInt(s2[1])));
                } else {
                    union(parent, rank, Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
                }
            }
        }
    }
    
    public static int find(int parent[], int i) {
        if(parent[i] == i) { // then this is the root node.
            return i;
        } else {
            parent[i] = find(parent, parent[i]); // find representative for each element and update it(path compression)
            return parent[i];
        }
    }
    
    public static void union(int parent[], int rank[], int x, int y) {
        int xrep = find(parent, x);
        int yrep = find(parent, y);
        
        if(xrep == yrep)
            return;
        
        if(rank[xrep] < rank[yrep])
            parent[xrep] = yrep;
        else if(rank[yrep] < rank[xrep])
            parent[yrep] = xrep;
        else {
            parent[yrep] = xrep;
            rank[xrep]++;
        }
    }
}
