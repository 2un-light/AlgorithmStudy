import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = new int[9];

        for(int i = 0; i < 9; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        int max = input[0];
        int loc = 1;
        for(int i = 0; i < 9; i++){
            if(max < input[i]){
                max = input[i];
                loc = i + 1;
            }
        }

        bw.write(String.valueOf(max) + "\n");
        bw.write(String.valueOf(loc));

        bw.flush();
        bw.close();
        br.close();

    }
}