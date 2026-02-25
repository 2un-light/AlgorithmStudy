import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] box;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        //박스 입력받기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) queue.offer(new int[]{i, j});
            }
        }

        bfs(queue);

        int result = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, box[i][j]);
            }
        }

        System.out.println(result - 1);

    }

    public static void bfs(Queue<int[]> queue) {

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(box[nx][ny] != 0) continue;


                box[nx][ny] = box[cx][cy] + 1;
                queue.offer(new int[]{nx, ny});

            }
        }

    }


}
