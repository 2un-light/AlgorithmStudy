import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        //n명의 사람
        int n = Integer.parseInt(input[0]);
        //k번째
        int k = Integer.parseInt(input[1]);

        Queue<Integer> person = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            person.offer(i+1);
        }

        sb.append("<");
        while(!person.isEmpty()){
            for(int j = 0; j < k - 1; j++){
                person.offer(person.poll());
            }
            sb.append(person.poll());
            if(!person.isEmpty()){
                sb.append(", ");
            }
        }
        sb.append(">");

        System.out.println(sb);


    }
}
