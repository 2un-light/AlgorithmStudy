import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] basket = new int[n];

        for(int i = 0; i < m; i++){
          st = new StringTokenizer(br.readLine());
          int start = Integer.parseInt(st.nextToken()) - 1;
          int end = Integer.parseInt(st.nextToken()) - 1;
          int x = Integer.parseInt(st.nextToken());

          for(int j = start; j <= end; j++){
              basket[j] = x;
          }
        }

        for(int i = 0; i < n; i++){
            bw.write(basket[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();


    }
}