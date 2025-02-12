import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] meetings = new int[N][2];

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(input[0]);
            meetings[i][1] = Integer.parseInt(input[1]);
        }

        //종료시간 기준 정렬
        Arrays.sort(meetings, Comparator.comparingInt((int[] m) -> m[1])
                                        .thenComparingInt(m -> m[0]));

        int cnt = 0;
        int endTime = 0;
        for(int[] meeting : meetings){
            if(meeting[0] >= endTime){
                cnt++;
                endTime = meeting[1];
            }
        }

        System.out.println(cnt);

    }
}
