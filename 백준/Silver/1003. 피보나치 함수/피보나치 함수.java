import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] cnt0, cnt1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        cnt0 = new int[41];
        cnt1 = new int[41];

        cnt0[0] = 1; cnt0[1] = 0;
        cnt1[0] = 0; cnt1[1] = 1;

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(cnt0[n]).append(" ").append(cnt1[n]).append("\n");

        }

        System.out.println(sb);

    }

    public static void fibonacci(int n) {
        if (cnt0[n] != 0 || cnt1[n] != 0 || n == 0) {
            return;
        }

        fibonacci(n - 1);
        fibonacci(n - 2);

        cnt0[n] = cnt0[n - 1] + cnt0[n - 2];
        cnt1[n] = cnt1[n - 1] + cnt1[n - 2];
    }
}
