import java.util.Arrays;

public class Solution {

    public static String solution(int[] numbers) {
       String[] strNums = new String[numbers.length];
       for(int i = 0; i < numbers.length; i++){
           strNums[i] = String.valueOf(numbers[i]);
       }

       Arrays.sort(strNums, (a,b) -> (b + a).compareTo(a + b));

       if(strNums[0].equals("0")) {
           return "0";
       }

       StringBuilder sb = new StringBuilder();
       for(String s : strNums) {
           sb.append(s);
       }

       return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
}
