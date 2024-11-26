import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        char[][] board = new char[row][column];
        for(int i = 0; i < row; i++){
            board[i] = br.readLine().toCharArray();
        }

        int minChanges = Integer.MAX_VALUE;
        // 모든 8x8 체스판의 시작점 탐색
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= column - 8; j++) {
                minChanges = Math.min(minChanges, countChanges(board, i, j));
            }
        }

        System.out.println(minChanges);



    }

    private static int countChanges(char[][] board, int x, int y){
        int changesPattern1 = 0; //맨 위 W
        int changesPattern2 = 0; //맨 위 B
        char[] pattern1 = {'W', 'B'};
        char[] pattern2 = {'B', 'W'};

        //8 x 8 크기탐색
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                char expectedPattern1 = pattern1[(i + j) % 2];
                char expectedPattern2 = pattern2[(i + j) % 2];

                if (board[x + i][y + j] != expectedPattern1) changesPattern1++;
                if (board[x + i][y + j] != expectedPattern2) changesPattern2++;
            }
        }

        return Math.min(changesPattern1, changesPattern2);

    }
}
