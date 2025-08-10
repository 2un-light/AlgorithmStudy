import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] numbers = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(numbers);

        int goodNumberCnt = 0;

        for(int i = 0; i < N; i++) {
            long target = numbers[i];
            int left = 0;
            int right = N - 1;

            while(left < right) {
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i) {
                    right--;
                    continue;
                }

                long sum = numbers[left] + numbers[right];
                if(sum == target) {
                    goodNumberCnt++;
                    break;
                }else if(sum < target){
                    left++;
                }else {
                    right --;
                }
            }
        }


        System.out.println(goodNumberCnt);
    }

}
