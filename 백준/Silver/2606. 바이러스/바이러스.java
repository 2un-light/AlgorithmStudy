import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            graph[com1].add(com2);
            graph[com2].add(com1);
        }

        dfs(1);
        System.out.println(count);

    }

    public static void dfs(int start) {
        visited[start] = true;

        for(int next : graph[start]) {
            if(!visited[next]) {
                count++;
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
