import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        int current = 1;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(input[i]);
            stack.push(num);

            while(!stack.isEmpty() && stack.peek() == current){
                stack.pop();
                current++;
            }
        }

        if(current == n + 1){
            System.out.println("Nice");
        }else{
            System.out.println("Sad");
        }


    }
}
