import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //숫자의 갯수
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        //숫자 배열에 저장
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(input[i]);
        }

        //연산자 저장
        input = br.readLine().split(" ");
        for(int i = 0; i < 4; i++){
            operators[i] = Integer.parseInt(input[i]);
        }


        solve(1, numbers[0]);

        //출력
        System.out.println(max);
        System.out.println(min);

    }

    public static void solve(int depth, int result){
        if(depth == N){
            max = Math.max(max, result);
            min = Math.min(min, result);
        }

        for(int i = 0; i < 4; i++){
            if(operators[i] > 0){
                operators[i]--;
                switch (i){
                    case 0 :
                        solve(depth + 1, result + numbers[depth]);
                        break;
                    case 1:
                        solve(depth + 1, result - numbers[depth]);
                        break;
                    case 2:
                        solve(depth + 1, result * numbers[depth]);
                        break;
                    case 3:
                        solve(depth + 1, result / numbers[depth]);
                        break;
                }
                operators[i]++;
            }
        }


    }
}
