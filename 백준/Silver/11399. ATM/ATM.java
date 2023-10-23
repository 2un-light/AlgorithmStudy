import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];
        int sum = 0;

        for(int i = 0; i < num; i++){
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        //출력하기
        for(int i = 0; i < num; i++){
            for(int j = 0; j < i; j++){
                sum += array[j];
            }
            sum += array[i];
        }
        System.out.println(sum);
    }


}