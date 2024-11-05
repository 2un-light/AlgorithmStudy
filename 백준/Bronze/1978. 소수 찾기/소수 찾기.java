import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int primeCount = 0;

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if(isPrime(num)){
                primeCount++;
            }
        }

        System.out.println(primeCount);

    }

    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
