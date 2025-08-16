import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int bit = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            int x = 0;
            if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case "add":
                    bit |= (1 << (x - 1));
                    break;
                case "remove":
                    bit &= ~(1 << (x - 1));
                    break;
                case "check":
                    sb.append((bit & (1 << (x - 1))) != 0 ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    bit ^= (1 << (x - 1));
                    break;
                case "all":
                    bit = (1 << 20) - 1;
                    break;
                case "empty":
                    bit = 0;
                    break;

            }

        }

        System.out.println(sb);
    }
}
