import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        //도로의 길이, 리터당 가격 입력받기
        int[] distances = new int[N - 1];
        int[] prices = new int[N];
        String[] roadInput = br.readLine().split(" ");
        String[] cityInput = br.readLine().split(" ");
        for(int i = 0; i < N - 1; i++){
            distances[i] = Integer.parseInt(roadInput[i]);
        }
        for(int i = 0; i < N; i++){
            prices[i] = Integer.parseInt(cityInput[i]);
        }
        
        int minCost = 0; //최소 비용
        int minPrice = prices[0]; //처음 주유소 가격

        for(int i = 0; i < N - 1; i++){
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
            minCost += minPrice * distances[i];
        }

        System.out.println(minCost);
    }
}
