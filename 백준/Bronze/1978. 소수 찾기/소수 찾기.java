import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(isPrime(num)) count++;
        }

        System.out.println(count);

    }

    private static boolean isPrime(int num) {
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for(int i = 3; i * i <= num; i += 2) {
            if(num % i == 0) return false;
        }

        return true;
    }
}
