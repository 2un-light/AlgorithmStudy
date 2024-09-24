import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String[] input = br.readLine().split(" ");

            int num1 = Integer.parseInt(input[0]);
            int num2 = Integer.parseInt(input[1]);

            int result = num1 + num2;

            if(result == 0){
                break;
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}