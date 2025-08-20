import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] Tsize = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 6; i++) {
             Tsize[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        //티셔츠 계산
        int TBundles = 0;
        for(int size : Tsize) {
            //올림을 정수 연산으로 구현
            TBundles += (size + T - 1) / T;
        }
        
        //펜 계산
        int penBundles = N / P;
        int penSigles = N % P;

        System.out.println(TBundles);
        System.out.println(penBundles + " " + penSigles);


    }
}
