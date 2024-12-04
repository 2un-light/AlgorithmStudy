import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for(int i = 3; i * i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break; // 0 이면 반복문 종료

            int cnt = 0;
            for(int i = num + 1; i <= num * 2; i++){
                if(isPrime(i)){
                    cnt++;
                }
            }

            System.out.println(cnt);

        }

    }
}