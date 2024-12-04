import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int MAX = 1000000; //주어진 문제에서의 최대 범위
        boolean[] isPrime = new boolean[MAX + 1];

        //에라토스테네스의 체로 소수 판별
        for(int i = 2; i <= MAX; i++){
            isPrime[i] = true;
        }
        for(int i = 2; i * i <= MAX; i++){
            if(isPrime[i]){
                for(int j = i * i; j <= MAX; j+= i){
                    isPrime[j] = false;
                }
            }
        }

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            int cnt = 0;

            //골드바흐 파티션 계산
            for(int j = 2; j <= num / 2; j++){
                if(isPrime[j] && isPrime[num - j]){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
