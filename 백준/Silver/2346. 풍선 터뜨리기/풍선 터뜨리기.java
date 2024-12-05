import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //n개의 풍선
        int n = Integer.parseInt(br.readLine());
        Deque<int[]> balloons = new ArrayDeque<>();

        //풍선 안에 적인 숫자
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(input[i]);
            balloons.offer(new int[]{i + 1, num});
        }

        while(!balloons.isEmpty()){
            int[] ballon = balloons.poll();
            int paperNum = ballon[1];
            sb.append(ballon[0]).append(" ");

            if(!balloons.isEmpty()){
                if(paperNum > 0){
                    for(int i = 0; i < paperNum - 1; i++){
                        balloons.offer(balloons.pollFirst());
                    }
                }else{
                    for(int i = 0; i < Math.abs(paperNum); i++){
                        balloons.offerFirst(balloons.pollLast());
                    }
                }
            }
        }

        System.out.println(sb);

    }
}
