import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] paper;
    static boolean[][] visited;
    static int max = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                visited[i][j] = false;

                checkT(i, j); //ㅗ모양 처리
            }
        }

        System.out.println(max);


    }

    private static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + paper[nx][ny]);
            visited[nx][ny] = false;
        }




    }

    private static void checkT(int x, int y) {
        int sum = paper[x][y];
        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

            cnt++;
            sum += paper[nx][ny];
            min = Math.min(min, paper[nx][ny]);
        }

        if(cnt >= 3) {
            if(cnt == 4) sum -= min;
            max = Math.max(max, sum);
        }
    }
}
