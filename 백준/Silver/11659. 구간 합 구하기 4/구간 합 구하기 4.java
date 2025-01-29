import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //수 배열 생성 후 입력
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        sum[0] = 0;
        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + num;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[end] - sum[start - 1]).append("\n");
        }

        System.out.println(sb);


    }
}
