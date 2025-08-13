import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    
    //상하좌우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static ArrayList<Integer> arrayList = new ArrayList<>();
    public static int cnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int x = 0; x < n; x++) {
            for(int y = 0; y < n; y++) {
                if(map[x][y] == 1 && !visited[x][y]) {
                    bfs(x, y);
                    cnt++;
                }
            }
        }

        sb.append(arrayList.size()).append("\n");

        Collections.sort(arrayList);
        for(int i : arrayList) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);


    }

    public static void bfs(int x, int y) {
        int houseCnt = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] loc = queue.poll();
            int cx = loc[0];
            int cy = loc[1];

            for(int dir = 0; dir < 4; dir++) {
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if(map[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        houseCnt++;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

        }

        arrayList.add(houseCnt);
    }
}
