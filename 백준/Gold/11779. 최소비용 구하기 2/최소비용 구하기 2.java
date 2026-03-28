import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int city;
        int cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int n, m;
    static List<Node>[] graph;
    static int[] dist;
    static int[] prev;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        prev = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[startCity].add(new Node(endCity, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        dijkstra(start);

        //최소 비용 출력
        System.out.println(dist[end]);

        List<Integer> path = new ArrayList<>();
        for(int i = end; i != 0; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);

        //경로 갯수 출력
        System.out.println(path.size());

        //경로 출력
        for(int p : path) {
            System.out.print(p + " ");
        }


    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.cost > dist[current.city]) continue;

            for(Node next : graph[current.city]) {
                if(dist[next.city] > current.cost + next.cost) {
                    //갱신
                    dist[next.city] = current.cost + next.cost;
                    prev[next.city] = current.city;
                    pq.offer(new Node(next.city, dist[next.city]));
                }
            }
        }
    }

}
