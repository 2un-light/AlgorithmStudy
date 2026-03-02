import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Main {
    static int n;
    static char[][] grid;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0 ,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        grid = new char[n][n];
        visited = new boolean[n][n];

        //grid 입력받기
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                grid[i][j] = input.charAt(j);
            }
        }

        int normal = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, false);
                    normal++;
                }
            }
        }

        //visited 초기화
        visited = new boolean[n][n];

        int blind = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, true);
                    blind++;
                }
            }
        }

        System.out.print(normal + " " + blind);



    }

    private static void bfs(int x, int y, boolean isBlind) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(visited[nx][ny]) continue;

                char curColor = grid[cx][cy];
                char nxtColor = grid[nx][ny];

                if(isBlind) {
                    if(curColor == 'R') curColor = 'G';
                    if(nxtColor == 'R') nxtColor = 'G';
                }

                if(curColor == nxtColor) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

    }
}
