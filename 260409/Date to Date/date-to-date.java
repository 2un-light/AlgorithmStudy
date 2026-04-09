import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Please write your code here.
        int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int bfM = Integer.parseInt(st.nextToken());
        int bfD = Integer.parseInt(st.nextToken());
        int aftM = Integer.parseInt(st.nextToken());
        int aftD = Integer.parseInt(st.nextToken());

        //before 일수 계산
        int beforeDays = 0;
        for(int i = 0; i < bfM; i++) {
            beforeDays += num_of_days[i];
        }
        beforeDays += bfD; //남은 일수 더하기

        //After 일수 계산
        int afterDays = 0;
        for(int i = 0; i < aftM; i++) {
            afterDays += num_of_days[i];
        }
        afterDays += aftD;

        System.out.println(afterDays - beforeDays + 1);

    }
}