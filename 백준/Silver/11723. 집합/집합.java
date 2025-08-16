import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            int num = 0;
            if(st.hasMoreTokens()) {
                num = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add" :
                    set.add(num);
                    break;
                case "remove":
                    if(set.contains(num)){
                        set.remove(num);
                    }
                    break;
                case "check":
                    if(set.contains(num)) {
                        sb.append(1).append("\n");
                    }else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    if (set.contains(num)) {
                        set.remove(num);
                    }else {
                        set.add(num);
                    }
                    break;
                case "all":
                    set.clear();
                    for(int s = 1; s <= 20; s++) {
                        set.add(s);
                    }
                    break;
                case "empty":
                    set.clear();

            }


        }

        System.out.println(sb);

    }
}
