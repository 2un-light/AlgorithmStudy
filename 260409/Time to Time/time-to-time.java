import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int beforeHour = Integer.parseInt(st.nextToken());
        int beforeMinute = Integer.parseInt(st.nextToken());
        int afterHour = Integer.parseInt(st.nextToken());
        int afterMinute = Integer.parseInt(st.nextToken());

        int minuteDiff = MinutesCal(afterHour, afterMinute) - MinutesCal(beforeHour, beforeMinute);
        
        System.out.println(minuteDiff);


    }

    public static int MinutesCal(int hour, int min) {
        return (60 * hour) + min;
    }
}