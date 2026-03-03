import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int[] parent;
    static char[] how;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            parent = new int[10000];
            how = new char[10000];

            bfs(a, b);

            sb.append(getCommand(a, b)).append("\n");
        }
        System.out.println(sb);

    }

    private static void bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(cur == target) return;

            //D일 경우
            int next = (cur * 2) % 10000;
            if(!visited[next]) {
                visited[next] = true;
                parent[next] = cur;
                how[next] = 'D';
                queue.offer(next);
            }

            //S일 경우
            next = (cur == 0) ? 9999 : cur - 1;
            if(!visited[next]) {
                visited[next] = true;
                parent[next] = cur;
                how[next] = 'S';
                queue.offer(next);
            }

            //L일 경우
            next = (cur % 1000) * 10 + (cur / 1000);
            if(!visited[next]) {
                visited[next] = true;
                parent[next] = cur;
                how[next] = 'L';
                queue.offer(next);
            }

            //R일 열루
            next = (cur % 10) * 1000 + (cur / 10);
            if(!visited[next]) {
                visited[next] = true;
                parent[next] = cur;
                how[next] = 'R';
                queue.offer(next);
            }

        }

    }

    private static String getCommand(int start, int target) {
        StringBuilder result = new StringBuilder();
        int cur = target;

        while(cur != start) {
            result.append(how[cur]);
            cur = parent[cur];
        }
        
        return result.reverse().toString();
    }
}