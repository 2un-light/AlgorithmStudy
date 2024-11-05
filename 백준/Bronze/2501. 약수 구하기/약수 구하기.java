import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> measure = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                measure.add(i);
            }
        }

        if(measure.size() >= K){
            System.out.println(measure.get(K - 1));
        }else{
            System.out.println(0);
        }





    }
}
