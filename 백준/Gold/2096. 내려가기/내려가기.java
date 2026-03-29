import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] maxDp = new int[3]; //최댓값 dp
        int[] minDp = new int[3]; //최솟값 dp


        //첫줄 초기값 세팅
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            int num = Integer.parseInt(st.nextToken());
            maxDp[i] = num;
            minDp[i] = num;
        }

        //2번째줄부터 비교
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            int[] maxPrev = maxDp.clone();
            int[] minPrev = minDp.clone();

            maxDp[0] = Math.max(maxPrev[0], maxPrev[1]) + first;
            maxDp[1] = Math.max(Math.max(maxPrev[0], maxPrev[1]), maxPrev[2]) + second;
            maxDp[2] = Math.max(maxPrev[1], maxPrev[2]) + third;

            minDp[0] = Math.min(minPrev[0], minPrev[1]) + first;
            minDp[1] = Math.min(Math.min(minPrev[0], minPrev[1]), minPrev[2]) + second;
            minDp[2] = Math.min(minPrev[1], minPrev[2]) + third;

        }

        Arrays.sort(minDp);
        Arrays.sort(maxDp);

        System.out.println(maxDp[2] + " " + minDp[0]);




    }
}
