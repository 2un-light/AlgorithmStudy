import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] graph;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        //그래프 생성 및 입력
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int dist = Integer.parseInt(st.nextToken());
                if(dist == 1) {
                    graph[i].add(j);
                }
            }
        }

        //정답
        result = new int[n][n];

        for(int i = 0; i < n; i++) {
           bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }

    public static void bfs(int start) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : graph[cur]) {
                if(!visited[nxt]) {
                    visited[nxt] = true;
                    result[start][nxt] = 1;
                    q.offer(nxt);
                }
            }
        }
    }
}
