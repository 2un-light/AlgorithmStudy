import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];

        int result = 1;
        for (int i = 0; i < 3; i++) {
            result *= Integer.parseInt(br.readLine());
        }

        String stringResult = Integer.toString(result);

        for(int i = 0; i < stringResult.length(); i++) {
            int num = stringResult.charAt(i) - '0';
            numbers[num]++;
        }

        for(int i : numbers) {
            System.out.println(i);
        }

    }
}
