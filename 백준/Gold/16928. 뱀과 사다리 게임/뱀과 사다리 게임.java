import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //사다리 정보 입력받기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            board[start] = end;

        }

        //뱀 정보 입력받기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            board[start] = end;
        }

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0}); //위치, 주사위 횟수
        visited[1] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int loc = cur[0];
            int count = cur[1];

            if(loc == 100) return count;

            for(int dice = 1; dice <= 6; dice++) {
                int next = loc + dice;

                if(next > 100) continue;

                //사다리 또는 뱀 이동
                if(board[next] != 0) {
                    next = board[next];
                }

                if(!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, count + 1});
                }
            }

        }

        return -1;
    }
}
