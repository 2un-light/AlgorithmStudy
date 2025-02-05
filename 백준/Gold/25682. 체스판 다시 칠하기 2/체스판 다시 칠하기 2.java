import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] diffW, diffB, sumW, sumB;

    static int getSum(int[][] sum, int x1, int y1, int x2, int y2) {
        return sum[x2][y2]
                - (y1 > 0 ? sum[x2][y1 - 1] : 0)
                - (x1 > 0 ? sum[x1 - 1][y2] : 0)
                + (x1 > 0 && y1 > 0 ? sum[x1 - 1][y1 - 1] : 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for(int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        diffW = new int[N][M];
        diffB = new int[N][M];
        sumW = new int[N][M];
        sumB = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                diffW[i][j] = (board[i][j] == expectedW) ? 0 : 1;
                diffB[i][j] = (board[i][j] == expectedB) ? 0 : 1;

                sumW[i][j] = diffW[i][j];
                sumB[i][j] = diffB[i][j];

                if (i > 0) {
                    sumW[i][j] += sumW[i - 1][j];
                    sumB[i][j] += sumB[i - 1][j];
                }
                if (j > 0) {
                    sumW[i][j] += sumW[i][j - 1];
                    sumB[i][j] += sumB[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    sumW[i][j] -= sumW[i - 1][j - 1];
                    sumB[i][j] -= sumB[i - 1][j - 1];
                }
            }
        }

        int minPaint = Integer.MAX_VALUE;
        for (int i = 0; i <= N - K; i++) {
            for (int j = 0; j <= M - K; j++) {
                int countW = getSum(sumW, i, j, i + K - 1, j + K - 1);
                int countB = getSum(sumB, i, j, i + K - 1, j + K - 1);
                minPaint = Math.min(minPaint, Math.min(countW, countB));
            }
        }

        System.out.println(minPaint);
    }
}
