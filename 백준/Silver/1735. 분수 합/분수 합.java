import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int numeratorA = Integer.parseInt(input[0]);
        int denominatorA = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int numeratorB = Integer.parseInt(input[0]);
        int denominatorB = Integer.parseInt(input[1]);

        int numeratorResult = (numeratorA * denominatorB) + (denominatorA * numeratorB);
        int denominatorResult = denominatorA * denominatorB;

        int i = 30000;
        while(i >= 1){
            if((numeratorResult % i == 0) && (denominatorResult % i == 0)){
                numeratorResult /= i;
                denominatorResult /= i;
            }
            i--;
        }

        System.out.println(numeratorResult + " " + denominatorResult);


    }
}
