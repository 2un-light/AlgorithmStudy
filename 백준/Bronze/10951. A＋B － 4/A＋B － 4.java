import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;

        while((line = br.readLine()) != null){
            String[] input = line.split(" ");
            int num1 = Integer.parseInt(input[0]);
            int num2 = Integer.parseInt(input[1]);
            int sum = num1 + num2;
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
