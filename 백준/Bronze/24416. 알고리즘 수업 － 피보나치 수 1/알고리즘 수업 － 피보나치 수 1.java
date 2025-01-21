import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] f;
    static int cnt1 = 0;
    static int cnt2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        f = new int[N + 1];
        fib(N);
        fibonacci(N);
        System.out.println(cnt1 + " " + cnt2);

    }

    public static int fib(int n){
        if(n == 1 || n == 2){
            cnt1++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibonacci(int n){
        f[1] = f[2] = 1;
        for(int i = 3; i <= n; i++){
            cnt2++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}