import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static long[] lines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        lines = new long[k];
        for(int i = 0; i < k; i++) {
            lines[i] = Long.parseLong(br.readLine());
        }


        Arrays.sort(lines);

        long start = 1;
        long end = lines[lines.length - 1];
        long answer = 0;
        while(start <= end) {

            long mid = (start + end) / 2;

            int cnt = 0;
            for(int i = 0; i < k; i++) {
                cnt += lines[i] / mid;
            }

           if(cnt >= n) {
               start = mid + 1;
               answer = mid;
           }else {
               end = mid - 1;
           }
        }

        System.out.println(answer);

    }
}
