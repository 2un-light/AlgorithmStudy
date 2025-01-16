import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        selected = new boolean[N];
        
        //능력치 표 입력
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                S[i][j] = Integer.parseInt(input[j]);
            }
        }

        solve(0, 0);
        System.out.println(min);

    }

    public static void solve(int depth, int start){
        if(depth == N / 2){
            calculateDiff();
            return;
        }

        for(int i = start; i < N; i++){
            if(!selected[i]){
                selected[i] = true;
                solve(depth + 1, i + 1);
                selected[i] = false;
            }
        }
    }

    public static void calculateDiff(){
        int star = 0;
        int link = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(selected[i] && selected[j]){
                    star += S[i][j];
                } else if (!selected[i] && !selected[j]) {
                    link += S[i][j];
                }
            }
        }

        int diff = Math.abs(star - link);
        min = Math.min(min, diff);
    }
}
