import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] tang = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            tang[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int answer = 0;

        for(int right = 0; right < N; right++) {
            map.put(tang[right], map.getOrDefault(tang[right], 0) + 1);

            while (map.size() > 2) {
                map.put(tang[left], map.get(tang[left]) - 1);
                if(map.get(tang[left]) == 0) map.remove(tang[left]);
                left++;
            }

            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);

    }

}
