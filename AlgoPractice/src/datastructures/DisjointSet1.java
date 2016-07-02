package datastructures;

/*
 A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. A union-find algorithm is an algorithm that performs two useful operations on such a data structure:

 Find: Determine which subset a particular element is in. This can be used for determining if two elements are in the same subset.

 Union: Join two subsets into a single subset.

 We can keeps track of the subsets in a 1D array, lets call it parent[].

 Initially, all slots of parent array are initialized to -1 (means there is only one item in every subset).

 0   1   2
 -1 -1  -1 

 0   1   2    <----- 1 is made parent of 0 (1 is now representative of subset {0, 1})
 1  -1  -1

 0   1   2    <----- 2 is made parent of 1 (2 is now representative of subset {0, 1, 2})
 1   2  -1
 */

import java.io.*;

class DisjointSet1 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1[] = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            int parent[] = new int[n + 1];
            for (int i = 0; i < n + 1; i++) {
                parent[i] = i;
            }
            while (m-- > 0) {
                String s2[] = br.readLine().split(" ");
                if (s2[0].equals("F")) {
                    System.out.println(find(parent, Integer.parseInt(s2[1])));
                } else {
                    union(parent, Integer.parseInt(s2[1]), Integer.parseInt(s2[2]));
                }
            }
        }
    }

    public static int find(int parent[], int i) {
        if (parent[i] == i) {
            return i;
        }
        return find(parent, parent[i]);
    }

    public static void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
}


/*
The above union() and find() are naive and the worst case time complexity is linear. The trees created to represent subsets can be skewed and can become like a linked list. Following is an example worst case scenario.

Let there be 4 elements 0, 1, 2, 3

Initially all elements are single element subsets.
0 1 2 3 

Do Union(0, 1)
   1   2   3  
  /
 0

Do Union(1, 2)
     2   3   
    /
   1
 /
0

Do Union(2, 3)
         3    
        /
      2
     /
   1
 /
0

*/