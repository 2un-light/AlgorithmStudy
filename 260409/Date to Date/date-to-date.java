import java.io.*;
import java.util.*;

public class Main {
    static int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int getDays(int month, int day) {
        int total = 0;
        for(int i = 1; i < month; i++) {
            total += num_of_days[i];
        }
        return total + day;
    }
    public static void main(String[] args) throws IOException{
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        

        int bfM = Integer.parseInt(st.nextToken());
        int bfD = Integer.parseInt(st.nextToken());
        int aftM = Integer.parseInt(st.nextToken());
        int aftD = Integer.parseInt(st.nextToken());

        int beforeDays = getDays(bfM, bfD);
        int afterDays = getDays(aftM, aftD);
    
        System.out.println(afterDays - beforeDays + 1);

    }
}