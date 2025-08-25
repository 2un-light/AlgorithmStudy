import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, priority});
                priorityQueue.offer(priority);
            }

            int cnt = 0;
            while(!queue.isEmpty()) {
                int[] current = queue.poll();
                if(current[1] == priorityQueue.peek()) {
                   cnt++;
                   if(current[0] == M) {
                       sb.append(cnt).append("\n");
                       break;
                   }
                   priorityQueue.poll();
                }else {
                    queue.offer(current);
                }
            }

        }

        System.out.println(sb);
        br.close();

    }
}
