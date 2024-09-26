import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputNM = br.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        int M = Integer.parseInt(inputNM[1]);
        int[] basket = new int[N];
        int[] balls = new int[3];

        for(int i = 0; i < M; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < 3; j++){
                balls[j] = Integer.parseInt(input[j]);
            }
            for(int k = balls[0]; k <= balls[1]; k++){
                basket[k - 1] = balls[2];
            }
        }

        for(int i = 0; i < N; i++){
            System.out.print(basket[i] + " ");
        }



    }
}
