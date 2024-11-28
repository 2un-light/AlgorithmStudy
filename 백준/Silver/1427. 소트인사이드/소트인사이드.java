import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] array = new int[input.length()];

       for(int i = 0; i < array.length; i++){
           array[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
       }

       //내림차순 정렬
        descendingOrder(array);

       for(int i = 0; i < array.length; i++){
           System.out.print(array[i]);
       }

    }

    public static int[] descendingOrder(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] < array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;

    }
}
