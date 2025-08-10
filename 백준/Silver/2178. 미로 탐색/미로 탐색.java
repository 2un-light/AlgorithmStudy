import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];

        System.out.println(bfs(0, 0));


    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            if(cx == N - 1 && cy == M - 1) {
                return graph[cx][cy];
            }

            for(int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(graph[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }


}
