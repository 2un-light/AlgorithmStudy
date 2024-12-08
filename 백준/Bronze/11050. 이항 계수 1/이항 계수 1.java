import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = 1;
        for(int i = n; i > n - k; i--){
            result *= i;
        }

        int result2 = 1;
        for(int i = k; i > 0; i--){
            result2 *= i;
        }

        System.out.println(result/result2);

    }
}
