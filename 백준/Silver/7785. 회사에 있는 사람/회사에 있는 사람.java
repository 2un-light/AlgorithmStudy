import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> employees = new HashSet<>();

        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            String name = input[0];
            String action = input[1];

            if(action.equals("enter")){
                employees.add(name);
            }else{
                employees.remove(name);
            }
        }

        List<String> result = new ArrayList<>(employees);
        result.sort(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String name : result) {
            sb.append(name).append("\n");
        }
        System.out.print(sb);
    }
}
