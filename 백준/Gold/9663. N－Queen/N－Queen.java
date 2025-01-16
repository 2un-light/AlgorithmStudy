import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] board;
    static int count = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N];
        queen(0);
        System.out.println(count);
    }

    public static void queen(int row){
        if(row == N){
            count++;
            return;
        }

        for(int col = 0; col < N; col++){
            board[row] = col;
            if(isValid(row)){
                queen(row + 1);
            }

        }
    }

    public static boolean isValid(int row){
        for(int i = 0; i < row; i++){
            if(board[i] == board[row] || Math.abs(board[row] - board[i]) == row - i){
                return false;
            }
        }
        return true;
    }
}
