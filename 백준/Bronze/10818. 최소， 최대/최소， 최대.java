import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] array = new int[N];


        for(int i = 0; i < N; i++){
            array[i] = Integer.parseInt(input[i]);
        }

        int max = array[0];
        int min = array[0];

        for(int i = 0; i < N; i++){

            if(min > array[i]){
                min = array[i];
            }

            if(max < array[i]){
                max = array[i];
            }
        }

        bw.write(String.valueOf(min) + " " + String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();
    }
}