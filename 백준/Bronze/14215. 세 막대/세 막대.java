import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int[] sides = {a,b,c};

        Arrays.sort(sides);

        if(sides[0] + sides[1] > sides[2]){
            System.out.println(Arrays.stream(sides).sum());
        }else{
            System.out.println(2 * (sides[0] + sides[1]) - 1);
        }

    }
}
