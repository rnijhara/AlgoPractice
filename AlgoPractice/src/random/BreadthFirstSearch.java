package random;

import java.util.LinkedList;

/**
 *
 * @author rex
 */
public class BreadthFirstSearch {
    static int V = 4;
    static int graph[][] = {{0, 1, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}};
    public static void main(String[] args) {
        bfs(2);
    }
    
    static void bfs(int i) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[i] = true;
        queue.add(i);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u+" ");
            for(int v = 0; v<V; v++) {
                if(graph[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
}
