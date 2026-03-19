import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);

        }

        bfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

       while(!queue.isEmpty()) {
           int node = queue.poll();
           for(int next : graph[node]) {
               if(!visited[next]) {
                   queue.offer(next);
                   visited[next] = true;
                   parent[next] = node;
               }
           }
       }
    }
}
