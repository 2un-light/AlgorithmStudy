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

        // n! / (n-k)!과 같다.
        int numerator  = 1;
        for(int i = n; i > n - k; i--){
            numerator  *= i;
        }

        // k!
        int denominator  = 1;
        for(int i = k; i > 0; i--){
            denominator  *= i;
        }

        System.out.println(numerator /denominator);

    }
}
