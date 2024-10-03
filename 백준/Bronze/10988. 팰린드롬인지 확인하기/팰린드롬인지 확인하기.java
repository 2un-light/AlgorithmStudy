import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int start = 0;
        int end = input.length() - 1;
        while(start < end){
            char ch1 = input.charAt(start);
            char ch2 = input.charAt(end);

            if(ch1 != ch2){
                System.out.println(0);
                return;
            }
            start++;
            end--;

        }
        System.out.println(1);
    }
}
