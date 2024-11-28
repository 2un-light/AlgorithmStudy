import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] count = new int[10001]; //숫자의 갯수를 저장하는 배열

        //입력된 숫자 카운트
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            count[num]++;
        }

        StringBuilder sb = new StringBuilder();
        //정렬결과 출력
        for(int i = 1; i < count.length; i++){
            while (count[i] > 0){
                sb.append(i).append("\n");
                count[i]--;
            }
        }

        System.out.println(sb);


    }
}