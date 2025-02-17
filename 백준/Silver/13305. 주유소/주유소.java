import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        //도로의 길이, 리터당 가격 입력받기
        int[] road = new int[N - 1];
        int[] city = new int[N];
        String[] roadInput = br.readLine().split(" ");
        String[] cityInput = br.readLine().split(" ");
        for(int i = 0; i < N - 1; i++){
            road[i] = Integer.parseInt(roadInput[i]);
        }
        for(int i = 0; i < N; i++){
            city[i] = Integer.parseInt(cityInput[i]);
        }
        
        //가격 산정
        int oilCost = road[0] * city[0]; //첫 도시에서 다음도시로 이동하는 가격

        //도시 중 기름값이 가장 작은 도시 찾기 (첫번째, 마지막 도시 제외)
        int minCity = Integer.MAX_VALUE;
        for(int i = 1; i < N - 1; i++){
            if(city[i] < minCity){
                minCity = city[i];
            }
        }

        //남은 거리를 기름값이 가장 작은 도시에서 충전
        int remainRoad = 0;
        for(int i = 1; i < N - 1; i++){
            remainRoad += road[i];
        }

        oilCost += remainRoad * minCity;

        System.out.println(oilCost);

    }
}
