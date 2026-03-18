import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        result = new int[M];

        //숫자 입력받기
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        backtrack(0);

    }

    public static void backtrack(int depth) {
        if(depth == M) {
            for(int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = numbers[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }




    }
}
