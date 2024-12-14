import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        char[][] star = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                star[i][j] = '*';
            }
        }

        removeMiddle(star, 0, 0, n);
        
        //출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void removeMiddle(char[][] star, int x, int y, int n){
        if(n == 1){
            return;
        }

        int third = n / 3;

        for(int i = x + third; i < x + third * 2; i++){
            for(int j = y + third; j < y + third * 2; j++){
                star[i][j] = ' ';
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(i == 1 && j == 1) continue;
                removeMiddle(star, x + i * third, y + j * third, third);
            }
        }



    }
}
