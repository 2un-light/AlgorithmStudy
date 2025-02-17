import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        //도로의 길이, 리터당 가격 입력받기
        long[] distances = new long[N - 1];
        long[] prices = new long[N];
        String[] roadInput = br.readLine().split(" ");
        String[] cityInput = br.readLine().split(" ");
        for(int i = 0; i < N - 1; i++){
            distances[i] = Integer.parseInt(roadInput[i]);
        }
        for(int i = 0; i < N; i++){
            prices[i] = Integer.parseInt(cityInput[i]);
        }

        long minCost = 0; //최소 비용
        long minPrice = prices[0]; //처음 주유소 가격

        for(int i = 0; i < N - 1; i++){
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            minCost += minPrice * distances[i];
        }

        System.out.println(minCost);
    }
}
