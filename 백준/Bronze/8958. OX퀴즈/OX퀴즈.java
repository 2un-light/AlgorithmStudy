import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String result = br.readLine();
            int score = 0;
            int cnt = 0;
            for(int j = 0; j < result.length(); j++) {
                if(result.charAt(j) == 'O') {
                    cnt++;
                    score += cnt;
                }else {
                    cnt = 0;
                }
            }

            sb.append(score).append("\n");
        }

        System.out.println(sb);

    }
}
