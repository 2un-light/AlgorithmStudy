import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        
        //알파벳 위치 저장 배열 -1로 초기화
        int[] position = new int[26];
        for(int i = 0; i < 26; i++){
            position[i] = -1;
        }

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int index = ch - 'a';

            if(position[index] == -1){
                position[index] = i;
            }

        }

        for(int i = 0; i < position.length; i++){
            bw.write(position[i] + " ");
        }
        


        bw.flush();
        bw.close();
        br.close();

    }
}