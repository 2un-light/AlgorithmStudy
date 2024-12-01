import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //최대공약수
    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];

        //가로수 위치
        for(int i = 0; i < N; i++){
            trees[i] = Integer.parseInt(br.readLine());
        }

        int[] gaps = new int[N - 1];
        for(int i = 0; i < N - 1; i++){
            gaps[i] = trees[i + 1] - trees[i];
        }

        int gcdValue = gaps[0];
        for(int i = 1; i < gaps.length; i++){
            gcdValue = gcd(gcdValue, gaps[i]);
        }

        int addTrees = 0;
        for(int gap : gaps){
            addTrees += (gap / gcdValue) - 1;
        }

        System.out.println(addTrees);

    }
}
