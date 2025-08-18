import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static Map<String, String> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String password = st.nextToken();

            map.put(address, password);
        }

        for(int i = 0; i < m; i++) {
            String address = br.readLine();
            bw.write(map.get(address));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();



    }
}
