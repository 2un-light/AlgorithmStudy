import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;

    static int[][][] box;

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[N][M][H];
        Queue<int[]> queue = new LinkedList<>();

        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for(int m = 0; m < M; m++) {
                    box[n][m][h] = Integer.parseInt(st.nextToken());
                    if(box[n][m][h] == 1) queue.offer(new int[]{n ,m, h});
                }
            }
        }

        bfs(queue);

        int result = 0;
        boolean allRipe = true;

        for(int h = 0; h < H; h++) {
            for(int n = 0; n < N; n++) {
                for(int m = 0; m < M; m++) {
                    if(box[n][m][h] == 0) {
                        allRipe = false;
                        break;
                    }
                    result = Math.max(result, box[n][m][h]);
                }
            }
        }

        if(allRipe) {
            System.out.println(result - 1);
        }else {
            System.out.println(-1);
        }


    }

    public static void bfs(Queue<int[]> queue) {
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int cz = current[2];

            for(int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) continue;
                if(box[nx][ny][nz] != 0) continue;

                box[nx][ny][nz] = box[cx][cy][cz] + 1;
                queue.offer(new int[]{nx, ny, nz});

            }
        }
    }

}
