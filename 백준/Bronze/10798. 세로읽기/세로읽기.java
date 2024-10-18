import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] arr = new char[5][15];
        int maxLen = 0;

        for(int i = 0; i < 5; i++){
            String str = br.readLine();
            maxLen = Math.max(maxLen, str.length());
            for(int j = 0; j < str.length(); j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int j = 0; j < maxLen; j++){
            for(int i = 0; i < 5; i++){
                if(arr[i][j] != '\0'){
                    sb.append(arr[i][j]);
                }
            }
        }

        System.out.println(sb.toString());


    }
}
