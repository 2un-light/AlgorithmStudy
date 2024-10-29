import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] input = br.readLine().split(" ");
            int num1 = Integer.parseInt(input[0]);
            int num2 = Integer.parseInt(input[1]);

            if(num1 == 0 && num2 == 0){
                break;
            }

            if(isFactor(num1, num2)){
                System.out.println("factor");
            }else{
                if(isMultiple(num1, num2)){
                    System.out.println("multiple");
                }else{
                    System.out.println("neither");
                }
            }

        }

    }

    public static boolean isFactor(int num1, int num2){
        if(num2 % num1 == 0){
            return true;
        }
        return false;
    }

    public static boolean isMultiple(int num1, int num2) {
        if(num1 % num2 == 0){
            return true;
        }
        return false;
    }

}
