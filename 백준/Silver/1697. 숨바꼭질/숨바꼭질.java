import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        q.offer(new int[]{n, 0});
        visited[n] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int loc = cur[0];
            int time = cur[1];

            if(loc == k) {
                System.out.println(time);
                break;
            }

            int[] next = {loc - 1, loc + 1, loc * 2};
            for(int nx : next) {
                if(nx >= 0 && nx <= 100000 && !visited[nx]) {
                    visited[nx] = true;
                    q.offer(new int[]{nx, time + 1});
                }
            }

        }



    }

}
