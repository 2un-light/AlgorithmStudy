import java.io.*;
import java.util.*;

public class Main {
    static String[] weeks = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
    static int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());


        //월 차이 계산
        int dayDiff = 0;
        if(m1 < m2) {
            for(int i = m1; i > m2; i++) {
                dayDiff += months[i];
            }
        }else {
            for(int i = m2; i < m1; i++) {
                dayDiff -= months[i];
            }
        }

        //일 계산
        dayDiff += (d2 - d1);

        //요일 계산
        int idx = (dayDiff % 7 + 7) % 7;

        System.out.println(weeks[idx]);

    }
}