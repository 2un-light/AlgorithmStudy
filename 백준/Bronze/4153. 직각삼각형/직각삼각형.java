import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();



        while (true) {
            int[] triangle = new int[3];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 3; i++) {
                int num = Integer.parseInt(st.nextToken());
                triangle[i] = (int) Math.pow(num, 2);
            }

            Arrays.sort(triangle);

            if(Arrays.stream(triangle).sum() == 0) {
                break;
            }

            if(triangle[0] + triangle[1] == triangle[2]) {
                sb.append("right").append("\n");
            }else {
                sb.append("wrong").append("\n");
            }


        }

        System.out.println(sb);

    }
}
