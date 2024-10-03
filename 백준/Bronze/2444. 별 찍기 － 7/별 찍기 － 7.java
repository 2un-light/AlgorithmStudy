import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        //위
        for(int i = 1; i <= n; i++){
            //공백
            for(int j = i; j < n; j++){
                System.out.print(" ");
            }

            //별
            for(int k = 1; k <= (2 * i - 1); k++){
                System.out.print("*");
            }
            System.out.println(" ");
        }

        // 아래쪽 역삼각형 부분
        for (int i = n - 1; i >= 1; i--) {
            // 공백 출력
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            // 별 출력
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        

    }
}
