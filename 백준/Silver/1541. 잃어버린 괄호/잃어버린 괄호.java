import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("-");
        int minSum = sumNumbers(input[0]);

        for(int i = 1; i < input.length; i++){
            minSum -= sumNumbers(input[i]);
        }

        System.out.println(minSum);

    }

    public static int sumNumbers(String numbers){
        String[] splitNum = numbers.split("\\+");
        int sum = 0;
        for(String num : splitNum){
            sum += Integer.parseInt(num);
        }

        return sum;
    }
}
