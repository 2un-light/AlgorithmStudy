import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int H = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int cookingTime = Integer.parseInt(br.readLine());

        int totalHour = H;
        int totalMinute = M + cookingTime;

        if(totalMinute >= 60){
            totalHour = H + (totalMinute/60);
            totalMinute = totalMinute % 60;

            if(totalHour >= 24){
                totalHour = totalHour % 24;
            }

        }

        System.out.println(totalHour + " " + totalMinute);
    }
}
