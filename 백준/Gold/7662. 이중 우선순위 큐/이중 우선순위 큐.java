import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            //횟수
            int K = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }else if(command.equals("D")) {
                    if(map.isEmpty()) continue;

                    //최댓값 삭제
                    if(num == 1) {
                        int max = map.lastKey();
                        if(map.get(max) == 1) map.remove(max);
                        else map.put(max, map.get(max) - 1);
                    }

                    //최솟값 삭제
                    else {
                        int min = map.firstKey();
                        if(map.get(min) == 1) map.remove(min);
                        else map.put(min, map.get(min) - 1);
                    }
                }
            }

            if(map.isEmpty()) {
                sb.append("EMPTY\n");
            }else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }



        }

        System.out.println(sb.toString());


    }
}
