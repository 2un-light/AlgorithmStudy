import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);

        backtrack(0);

        System.out.println(sb);


    }

    public static void backtrack(int depth) {
        if(depth == M) {
            for(int num : answer) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;

        for(int i = 0; i < N; i++) {
            if(!visited[i] && prev != arr[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                prev = arr[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }

    }
}
