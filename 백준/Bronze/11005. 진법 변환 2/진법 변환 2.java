import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(N > 0){
            int remain = N % B;

            if(remain < 10) {
                sb.append(remain);
            }else{
                sb.append((char)(remain + 55));
            }

            N /= B;

        }

        System.out.println(sb.reverse().toString());


    }
}
