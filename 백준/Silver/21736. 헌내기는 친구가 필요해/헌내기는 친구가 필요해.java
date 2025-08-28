import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        campus = new char[n][m];
        visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                campus[i][j] = input.charAt(j);
                if(campus[i][j] == 'I'){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int meet = 0;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    if(campus[nx][ny] == 'O' || campus[nx][ny] == 'P') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        if (campus[nx][ny] == 'P') meet++;
                    }
                }
            }
        }

        if(meet > 0) {
            System.out.println(meet);
        }else {
            System.out.println("TT");
        }


    }
}
