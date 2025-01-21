import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int[] result;
    static boolean[] marked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        result = new int[M];
        marked = new boolean[N + 1];
        solve(0);

    }

    public static void solve(int depth){
        if(depth == M){
            for(int num : result){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!marked[i]){
                marked[i] = true;
                result[depth] = i;
                solve(depth + 1);
                marked[i] = false;
            }
        }
    }
}
