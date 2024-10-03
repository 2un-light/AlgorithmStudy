import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] chessSet = {1, 1, 2, 2, 2, 8};
        int[] pieceArray = new int[6];

        //입력 공백 분리
        String[] input = br.readLine().split(" ");

        for(int i = 0; i < 6; i++){
            pieceArray[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i < 6; i++){
            bw.write((chessSet[i] - pieceArray[i]) + " ");
        }

        bw.flush();
        bw.close();
        br.close();



    }
}