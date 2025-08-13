import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int t, m, n, k;
    public static int[][] field;
    public static boolean[][] visited;

    public static int cnt;

    //상하좌우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            field = new int[n][m];
            visited = new boolean[n][m];
            cnt = 0;

            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            for(int k = 0; k < n; k++) {
                for(int l = 0; l < m; l++) {
                    if( (field[k][l] == 1) && !visited[k][l]) {
                        bfs(k, l);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");

        }

        System.out.println(sb);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] array = queue.poll();
            int cx = array[0];
            int cy = array[1];

            if(cx == n - 1 && cy == m - 1) {
                return;
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny] && field[nx][ny] == 1){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }


            }


        }

    }
}
