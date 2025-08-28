import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, b;
    public static int[][] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        ground = new int[n][m];
        int minH = 256, maxH = 0;

        //입력 받기 & 최소 최대 높이 찾기
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, ground[i][j]);
                maxH = Math.max(maxH, ground[i][j]);
            }
        }

        int timeResult = Integer.MAX_VALUE;
        int heightResult = 0;

        for(int target = minH; target <= maxH; target++) {
            int time = 0;
            int inventory = b;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    int diff = ground[i][j] - target;

                    if(diff > 0) {
                        time += 2 * diff;
                        inventory += diff;
                    } else if (diff < 0) {
                        time += (-diff);
                        inventory += diff; //diff는 음수
                    }
                }
            }

            if (inventory < 0) continue;
        
            //최소시간 갱신, 같을땐 더 높은 높이 선택
            if(time < timeResult || (time == timeResult && target > heightResult)) {
                timeResult = time;
                heightResult = target;
            }

        }

        System.out.println(timeResult + " " + heightResult);

    }
}
