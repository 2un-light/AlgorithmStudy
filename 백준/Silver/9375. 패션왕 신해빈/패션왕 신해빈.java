import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //테스트 케이스
        int t = Integer.parseInt(br.readLine());

        //입력
        while(t-- > 0) {
            //의상 수
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> clothes = new HashMap<>();
            for(int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                String kind = input[1];

                clothes.put(kind, clothes.getOrDefault(kind, 0) + 1);
            }

            int result = 1;
            for(int cnt : clothes.values()) {
                result *= (cnt + 1);
            }
            result -= 1;

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }
}
