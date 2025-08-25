import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int exCludeCount = (int) Math.round(N * 0.15);

        int[] opinion = new int[N];
        for(int i = 0; i < N; i++) {
            opinion[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(opinion);

        int sum = 0;
        int cnt = 0;
        for(int i = exCludeCount; i < N - exCludeCount; i++) {
            sum += opinion[i];
            cnt++;
        }
        int result = Math.round((float) sum / cnt);
        System.out.println(result);

    }
}
