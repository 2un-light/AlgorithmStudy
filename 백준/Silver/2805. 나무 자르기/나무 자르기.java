import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] woods = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            woods[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(woods);

        int start = 0;
        int end = woods[woods.length - 1];

        int result = 0;
        while(start <= end) {
            long total = 0;
            int mid = (start + end) / 2;

            for(int wood : woods) {
                if(wood > mid) {
                    total += (wood - mid);
                }
            }

            if(total < m) {
                end = mid - 1;
            }else {
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);

    }
}
