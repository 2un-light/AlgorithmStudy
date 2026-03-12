import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        int answer = n;

        for(int i = 0; i < wires.length; i++) {

            graph = new ArrayList[n + 1];
            for(int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            // i번째 전선 제거
            for(int j = 0; j < wires.length; j++) {
                if(i == j) continue;

                int a = wires[j][0];
                int b = wires[j][1];

                graph[a].add(b);
                graph[b].add(a);
            }

            visited = new boolean[n + 1];
            int count = dfs(1);

            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    static int dfs(int node) {
        visited[node] = true;
        int count = 1;

        for(int next : graph[node]) {
            if(!visited[next]) {
                count += dfs(next);
            }
        }

        return count;
    }
}