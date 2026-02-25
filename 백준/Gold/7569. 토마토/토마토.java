import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] box;
    static int M, N, H;

    // 6방향: 상하좌우 + 위아래 층
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열 (x축)
        N = Integer.parseInt(st.nextToken()); // 행 (y축)
        H = Integer.parseInt(st.nextToken()); // 높이 (층)

        box = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();

        // 입력 및 익은 토마토 큐에 삽입
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box[h][n][m] = Integer.parseInt(st.nextToken());
                    if (box[h][n][m] == 1) {
                        queue.offer(new int[]{h, n, m});
                    }
                }
            }
        }

        // BFS
        bfs(queue);

        int result = 0;
        boolean allRipe = true;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[h][n][m] == 0) {
                        allRipe = false;
                        break;
                    }
                    result = Math.max(result, box[h][n][m]);
                }
            }
        }

        if (!allRipe) {
            System.out.println(-1);
        } else {
            System.out.println(result - 1);
        }
    }

    static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int ch = cur[0], cy = cur[1], cx = cur[2];

            for (int i = 0; i < 6; i++) {
                int nh = ch + dh[i];
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (nh < 0 || nh >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (box[nh][ny][nx] != 0) continue;

                box[nh][ny][nx] = box[ch][cy][cx] + 1;
                queue.offer(new int[]{nh, ny, nx});
            }
        }
    }
}
