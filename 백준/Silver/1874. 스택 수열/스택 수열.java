import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N];
        for(int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int current = 1;

        for(int i = 0; i < N; i++) {
            int target = sequence[i];

            while(current <= target) {
                stack.push(current++);
                sb.append("+\n");
            }

            if(stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            }else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
