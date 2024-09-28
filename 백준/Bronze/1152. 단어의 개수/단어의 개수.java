import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String[] words = input.split(" ");

        int cnt = 0;
        for(String s : words){
            if(!s.isEmpty()){
                cnt++;
            }
        }

        System.out.println(cnt);


    }
}