import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        Long num1 = Long.parseLong(input[0]);
        Long num2 = Long.parseLong(input[1]);
        Long num3 = Long.parseLong(input[2]);

        System.out.println(num1 + num2 + num3);

    }
}