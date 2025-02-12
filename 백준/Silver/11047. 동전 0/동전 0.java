import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Integer[] coins = new Integer[N];
        for(int i = 0; i < N; i++){
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }
        Arrays.sort(coins, Collections.reverseOrder());

        int cnt = 0;
        for(int i = 0; i < N; i++){
            cnt += K / coins[i];
            K %= coins[i];
            if(K == 0){
                break;
            }
        }

        System.out.println(cnt);

    }
}
