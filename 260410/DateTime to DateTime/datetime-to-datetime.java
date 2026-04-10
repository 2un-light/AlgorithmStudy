import java.io.*;
import java.util.*;

public class Main {
    //static int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static int toMinutes(int day, int hour, int minute) {
        //dayToHour
        hour += day * 24;
        minute += hour * 60;
        return minute;
    }

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        int before = toMinutes(11, 11, 11);
        int after = toMinutes(day, hour, minute);

        if(after < before) {
            System.out.println(-1);
        }else {
            System.out.println(after - before);
        }

    }
}