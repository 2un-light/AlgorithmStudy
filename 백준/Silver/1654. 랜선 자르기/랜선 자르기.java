import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());


        long[] lan = new long[K];
        long max = 0;
        for(int i = 0; i < K; i++) {
            lan[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lan[i]);
        }


        long start = 1;
        long end = max;
        long length = 0;

        while(start <= end) {
            long mid = (start + end) / 2;

            int count = 0;
            for(long l : lan) {
                count += l / mid;
            }

            if(count < N) {
                end = mid - 1;
            }else {
                length = mid;
                start = mid + 1;
            }
        }

        System.out.println(length);

    }
}
