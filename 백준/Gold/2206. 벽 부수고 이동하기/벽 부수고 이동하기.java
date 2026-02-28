import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] visited;
    static int ans = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N, M 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //지도 생성
        map = new int[N][M];

        //[N] - x, [M] - y, [broken] - 벽을 부순 횟수
        visited = new boolean[N][M][2];

        //지도 입력받기
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0, 0, 0, 1);

        System.out.println(ans);


    }

    private static void bfs(int x, int y, int broken, int dist) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, broken, dist});
        visited[x][y][broken] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int isBroken = cur[2];
            int distance = cur[3];

            if(cx == N - 1 && cy == M - 1) {
                ans = distance;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(map[nx][ny] == 0 && !visited[nx][ny][isBroken]) {
                    visited[nx][ny][isBroken] = true;
                    queue.offer(new int[]{nx, ny, isBroken, distance + 1});
                }else if(map[nx][ny] == 1 && isBroken == 0 && !visited[nx][ny][isBroken]) {
                    visited[nx][ny][1] = true;
                    queue.offer(new int[]{nx, ny, 1, distance + 1});
                }
            }

        }


    }
}
