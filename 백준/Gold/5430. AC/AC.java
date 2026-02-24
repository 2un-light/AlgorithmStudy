import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {

            String func = br.readLine();
            int n = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();

            //배열 입력 처리
            String input = br.readLine();
            input = input.substring(1, input.length() - 1);

            if(n > 0) {
                String[] parts = input.split(",");
                for(String s : parts) {
                    deque.add(Integer.parseInt(s));
                }
            }

            boolean reverse = false;
            boolean error = false;

            for(char c : func.toCharArray()) {

                if(c == 'R') {
                    reverse = !reverse;
                }

                else if(c == 'D') {
                    if(deque.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }

                    if(!reverse) {
                        deque.pollFirst();
                    }else {
                        deque.pollLast();
                    }
                }
            }

            if(error) continue;

            sb.append("[");
            while(!deque.isEmpty()) {
                if(!reverse) {
                    sb.append(deque.pollFirst());
                }else {
                    sb.append(deque.pollLast());
                }
                
                if(!deque.isEmpty()) sb.append(",");
            }

            sb.append("]\n");

        }

        System.out.println(sb);

    }
}
