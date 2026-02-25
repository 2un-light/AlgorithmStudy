import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        deque.offer(new int[]{N, 0});

        while(!deque.isEmpty()) {
            int[] cur = deque.poll();

            int loc = cur[0];
            int time = cur[1];


            if(loc == K) {
                System.out.println(time);
                return;
            }

            if(loc * 2 <= 100000 && !visited[loc * 2]) {
                deque.addFirst(new int[]{loc * 2, time});
            }

            if(loc + 1 <= 100000 && !visited[loc + 1]) {
                deque.addLast(new int[]{loc + 1, time + 1});
            }

            if(loc - 1 >= 0 && !visited[loc - 1]) {
                deque.addLast(new int[]{loc - 1, time + 1});
            }

            visited[loc] = true;

        }


    }
}
