import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;

        for(int i = 0; i < T; i++){
            int C = Integer.parseInt(br.readLine());

            quarter = C / 25;
            dime = (C % 25) / 10;
            nickel = (C % 25 % 10) / 5;
            penny = (C % 25 % 10 % 5) / 1;

            bw.write(quarter + " ");
            bw.write(dime + " ");
            bw.write(nickel + " ");
            bw.write(penny + "\n");

        }

        bw.flush();
        bw.close();
        br.close();




    }
}
