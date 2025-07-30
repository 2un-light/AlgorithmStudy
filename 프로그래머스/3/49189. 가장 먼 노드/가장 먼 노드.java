import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    q.offer(next);
                }
            }
        }

        int maxDist = 0;
        for (int d : dist) {
            maxDist = Math.max(maxDist, d);
        }

        int cnt = 0;
        for (int d : dist) {
            if (d == maxDist) {
                cnt++;
            }
        }

        return cnt;
    }
}