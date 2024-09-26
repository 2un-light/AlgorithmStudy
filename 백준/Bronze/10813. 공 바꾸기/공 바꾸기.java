import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //바구니
        int[] basket = new int[n];

        //바구니에 공 넣기
        for(int i = 0; i < n; i++){
            basket[i] = i + 1;
        }

        for(int k = 0; k < m; k++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            int temp = basket[i];
            basket[i] = basket[j];
            basket[j] = temp;

        }

        for(int k = 0; k < n; k++){
            bw.write(basket[k] + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
