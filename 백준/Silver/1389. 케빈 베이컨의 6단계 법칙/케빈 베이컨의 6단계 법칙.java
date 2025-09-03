import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = (int) 1e9;
    static int n, m;
    static int[][] bacon;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bacon = new int[n + 1][n + 1];

        //초기화
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) bacon[i][j] = 0;
                else bacon[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bacon[a][b] = 1;
            bacon[b][a] = 1;
        }
        
        //플로이드 워셜 알고리즘
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(bacon[i][j] > bacon[i][k] + bacon[k][j]) {
                        bacon[i][j] = bacon[i][k] + bacon[k][j];
                    }
                }
            }
        }

        int minSum = INF;
        int answer = -1;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <= n; j++) {
                sum += bacon[i][j];
            }

            if(sum < minSum) {
                minSum = sum;
                answer = i;
            }
        }

        System.out.println(answer);



    }
}
