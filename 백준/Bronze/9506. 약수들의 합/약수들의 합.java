import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int N = Integer.parseInt(br.readLine());

            //-1일때 프로그램 종료
            if(N == -1){
                break;
            }
            
            //약수 구하기
            ArrayList<Integer> measure = new ArrayList<>();
            for(int i = 1; i < N; i++){
                if(N % i == 0){
                    measure.add(i);
                }
            }
            
            //자기 자신을 뺀 약수들의 합
            int sum = 0;
            for(int i = 0; i < measure.size(); i++){
                sum += measure.get(i);
            }

            //완전수인지 아닌지 판단해서 출력
            if(sum == N){
                System.out.print(N + " = ");
                for(int i = 0; i < measure.size() - 1; i++){
                    System.out.print(measure.get(i) + " + ");
                }
                System.out.println(measure.get(measure.size() - 1));

            }else{
                System.out.println(N + " is NOT perfect.");
            }
        }

    }
}
