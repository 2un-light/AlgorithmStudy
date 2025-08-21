import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input.equals("0")) {
                break;
            }

            int start = 0;
            int end = input.length() - 1;
            boolean isPalindrome = true;
            while (start < end) {
                if (input.charAt(start) != input.charAt(end)) {
                    isPalindrome = false;
                    break;
                }
                start++;
                end--;

            }

            if(isPalindrome){
                sb.append("yes\n");
            }else{
                sb.append("no\n");
            }
        }

        System.out.println(sb);


    }
}
