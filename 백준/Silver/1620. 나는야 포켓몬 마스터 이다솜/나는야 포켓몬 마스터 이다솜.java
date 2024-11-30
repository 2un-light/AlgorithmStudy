import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<Integer, String> numberToName = new HashMap<>();
        Map<String, Integer> nameToNumber = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numberToName.put(i, name);
            nameToNumber.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String query = br.readLine();

            if (query.charAt(0) >= '0' && query.charAt(0) <= '9') {
                int num = Integer.parseInt(query);
                System.out.println(numberToName.get(num));
            } else {
                System.out.println(nameToNumber.get(query));
            }
        }


    }
}
