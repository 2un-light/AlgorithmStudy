import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long M = 1234567891;
        long result = 0;
        long r = 1;
        for(int i = 0; i < L; i++) {
            int number = str.charAt(i) - 'a' + 1;
            result = (result + number * r) % M;
            r = (r * 31) % M;
        }

        System.out.println(result);

    }
}
