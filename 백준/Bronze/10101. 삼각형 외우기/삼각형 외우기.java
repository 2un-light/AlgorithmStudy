import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] angle = new int[3];

        angle[0] = Integer.parseInt(br.readLine());
        angle[1] = Integer.parseInt(br.readLine());
        angle[2] = Integer.parseInt(br.readLine());

        if((angle[0] == 60) && (angle[1] == 60) && (angle[2] == 60)){
            System.out.println("Equilateral");
        }else{
            if(Arrays.stream(angle).sum() == 180){
               //두 각이 같은 경우
                if((angle[0] == angle[1]) || (angle[1] == angle[2]) || (angle[2] == angle[0])){
                    System.out.println("Isosceles");
                    //아닌경우
                }else{
                    System.out.println("Scalene");
                }

            }else{
                System.out.println("Error");
            }
        }

    }
}
