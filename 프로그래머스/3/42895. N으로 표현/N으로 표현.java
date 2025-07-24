import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {

        int n = 5;
        int number = 12;

        System.out.println(solution(n, number));

    }

    public static int solution(int n, int number) {
        if(n == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();

        for(int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for(int i = 1; i <= 8; i++) {
            int repeatedN = Integer.parseInt(String.valueOf(n).repeat(i));
            dp.get(i).add(repeatedN);

            for(int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);

                for(int a : set1) {
                    for(int b : set2) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if( b != 0 ) dp.get(i).add(a / b);
                    }
                }
            }
            System.out.println(dp);

            if(dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
