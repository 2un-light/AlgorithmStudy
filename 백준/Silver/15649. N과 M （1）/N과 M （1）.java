import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] result;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];
        checked = new boolean[N + 1];
        backtracking(0);

    }

    public static void backtracking(int depth){
        if(depth == M){
            for(int num : result){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!checked[i]){
                checked[i] = true;
                result[depth] = i;
                backtracking(depth + 1);
                checked[i] = false;
            }
        }

    }

}
