import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2) return true; 
        if (num % 2 == 0) return false;

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            while (true) {
                if (isPrime(num)) { 
                    sb.append(num).append("\n");
                    break;
                }
                num++;
            }
        }

        System.out.print(sb);
    }
}
