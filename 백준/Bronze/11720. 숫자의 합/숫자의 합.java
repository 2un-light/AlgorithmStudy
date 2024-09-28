import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //숫자의 갯수
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        bw.close();
        br.close();

    }
}