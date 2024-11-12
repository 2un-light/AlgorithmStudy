import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        int[] y = new int[n];


        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int maxX = x[0];
        int minX = x[0];
        int maxY = y[0];
        int minY = y[0];

        for(int i = 0; i < n; i++){
            if(x[i] < minX){
                minX = x[i];
            }
            if(x[i] > maxX){
                maxX = x[i];
            }
            if(y[i] < minY){
                minY = y[i];
            }
            if(y[i] > maxY){
                maxY = y[i];
            }

        }

        System.out.println((maxX - minX) * (maxY - minY));

    }
}
