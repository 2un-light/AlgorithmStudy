import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트 케이스 갯수
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            String str = br.readLine();
            bw.write(str.charAt(0));
            bw.write(str.charAt(str.length() - 1));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}