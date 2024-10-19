import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] paper = new int[100][100];

        //색종이의 갯수
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j = x; j < x + 10; j++){
                for(int k = y; k < y + 10; k++){
                    paper[j][k] = 1;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
               if(paper[i][j] == 1){
                   cnt++;
               }
            }
        }

        System.out.println(cnt);


    }
}