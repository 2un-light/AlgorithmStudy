import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[] bulbs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bulbs = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            bulbs[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            switch (command) {
                case 1:
                    bulbs[start - 1] = end;
                    break;
                case 2:
                    for (int j = start - 1; j < end; j++) {
                        bulbs[j] = bulbs[j] == 0 ? 1 : 0;
                    }
                    break;
                case 3:
                    for(int j = start - 1; j < end; j++) {
                        bulbs[j] = 0;
                    }
                    break;
                case 4:
                    for(int j = start - 1; j < end; j++) {
                        bulbs[j] = 1;
                    }
            }
        }

        for(int bulb : bulbs) {
            System.out.print(bulb + " ");
        }


    }
}
