import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Hx, Hy, Ex, Ey;
    static int[][] maze;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //맵 크기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //출발점
        st = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(st.nextToken()) - 1;
        Hy = Integer.parseInt(st.nextToken()) - 1;

        //도착점
        st = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(st.nextToken()) - 1;
        Ey = Integer.parseInt(st.nextToken()) - 1;

        maze = new int[N][M];

        //맵 정보 입력받기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //visited[n][m][used] - used 0=미사용 1=사용
        boolean[][][] visited = new boolean[N][M][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{Hx, Hy, 0, 0});
        visited[Hx][Hy][0] = true;

        int ans = -1;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int used = cur[2];
            int dist = cur[3];

            if(cx == Ex && cy == Ey) {
                ans = dist;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(maze[nx][ny] == 0 && !visited[nx][ny][used]) {
                    visited[nx][ny][used] = true;
                    queue.offer(new int[]{nx, ny, used, dist + 1});
                }else if(maze[nx][ny] == 1 && used == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.offer(new int[]{nx, ny, 1, dist + 1});
                }
            }

        }

        System.out.println(ans);


    }
}
