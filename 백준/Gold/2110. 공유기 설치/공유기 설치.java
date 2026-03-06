import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] house = new int[N];
        for(int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int startDist = 1;
        int endDist = house[N - 1] - house[0];
        int answer = 0;
        while(startDist <= endDist) {
            int midDist = (startDist + endDist) / 2;
            int count = 1;
            int last = house[0];

            for(int i = 1; i < N; i++) {
                if(house[i] - last >= midDist) {
                    count++;
                    last = house[i];
                }
            }

            if(count >= C) {
                answer = midDist;
                startDist = midDist + 1;
            }else {
                endDist = midDist - 1;
            }
        }

        System.out.println(answer);


    }
}
