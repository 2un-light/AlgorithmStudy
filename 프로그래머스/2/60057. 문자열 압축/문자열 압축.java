import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.println(solution(str));

    }

    public static int solution(String s) {
        int minLength = s.length();

        for(int step = 1; step <= s.length() / 2; step++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, step);
            int cnt = 1;

            for(int j = step; j < s.length(); j+= step) {
                int end = Math.min(j + step, s.length());
                String current = s.substring(j, end);

                if(prev.equals(current)) {
                    cnt++;
                }else {
                    if(cnt > 1) sb.append(cnt);
                    sb.append(prev);
                    prev = current;
                    cnt = 1;
                }
            }
            //남은 문자열 처리
            if(cnt > 1) sb.append(cnt);
            sb.append(prev);

            minLength = Math.min(minLength, sb.length());
        }

        return minLength;
    }
}
