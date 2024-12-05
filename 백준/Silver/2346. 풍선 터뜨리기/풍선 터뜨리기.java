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
        Deque<Integer> balloons = new ArrayDeque<>();

        //풍선 안에 적인 숫자
        String[] input = br.readLine().split(" ");
        Deque<Integer> numbers = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            balloons.offer(i + 1);
            numbers.offer(Integer.parseInt(input[i]));
        }
        
        sb.append(balloons.poll()).append(" "); //첫번째 풍선 터뜨리기
        int paperNum = numbers.poll();
        while(!balloons.isEmpty()){
            if(paperNum > 0){
                for(int i = 0; i < paperNum - 1; i++){
                    balloons.offer(balloons.poll());
                    numbers.offer(numbers.poll());
                }
                sb.append(balloons.poll()).append(" ");
                paperNum = numbers.poll();
            }else{
                paperNum *= -1;
                for(int i = 0; i < paperNum; i++){
                    balloons.offerFirst(balloons.pollLast());
                    numbers.offerFirst(numbers.pollLast());
                }
                sb.append(balloons.poll()).append(" ");
                paperNum = numbers.poll();
            }
        }
        System.out.println(sb);

    }
}
