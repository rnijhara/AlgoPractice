/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

/**
 *
 * @author rex
 */
public class DepthFirstSearch {
    static int V = 4;
    static int graph[][] = {{0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}};
    static boolean visited[] = new boolean[4];
    static int parent[] = new int[4];
    public static void main(String[] args) {
        dfs(2);
    }
    
    static void dfs(int i) {
        visited[i] = true;
        System.out.print(i+" ");
        for(int j=0; j<4; j++) {
            if(graph[i][j] == 1 && !visited[j]) {
                parent[j] = i;
                dfs(j);
            }
        }
    }
}
