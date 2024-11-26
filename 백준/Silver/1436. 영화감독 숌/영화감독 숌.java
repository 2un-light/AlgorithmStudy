import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = 0;
        int count = 0;
        while(true){
            if(String.valueOf(num).contains("666")){
                count++;
            }
            if(count == N){
                break;
            }
            num++;
        }

        System.out.println(num);
    }
}
