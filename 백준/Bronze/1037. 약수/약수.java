import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        String[] input = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(input[i]);
            if(array[i] < min){
                min = array[i];
            }
            if(array[i] > max){
                max = array[i];
            }
        }

        Arrays.sort(array);

        if(array.length % 2 == 0){
            System.out.println(max * min);
        }else{
            int midValue = array[array.length / 2];
            System.out.println(midValue * midValue);
        }
    }
}
