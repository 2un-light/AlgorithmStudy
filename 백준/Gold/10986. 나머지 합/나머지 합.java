import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] count = new long[M];
        long sum = 0;
        long result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sum += Integer.parseInt(st.nextToken());
            int remainder = (int) (sum % M);

            if(remainder == 0) result++;
            count[remainder]++;
        }

        for(int i = 0; i < M; i++){
            if(count[i] > 1) {
                result += (count[i] * (count[i] - 1)) / 2;
            }
        }

        System.out.println(result);
    }
}
