import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> absHeap = new PriorityQueue<>((a, b) -> {
            if(Math.abs(a) == Math.abs(b)) {
                return a - b;
            }
            return Math.abs(a) - Math.abs(b);
        });

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(absHeap.isEmpty()) {
                    System.out.println(0);
                }else{
                    System.out.println(absHeap.poll());
                }
            }else {
                absHeap.offer(num);
            }
        }
    }
}
