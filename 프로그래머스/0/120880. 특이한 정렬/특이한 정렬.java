import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] numlist = {10000, 20, 36, 47, 40, 6, 10, 7000};
        int n = 30;
        System.out.println(Arrays.toString(solution(numlist, n)));
    }

    public static int[] solution(int[] numlist, int n) {
        for (int i = 0; i < numlist.length - 1; i++) {
            for (int j = i + 1; j < numlist.length; j++) {
                int diffI = Math.abs(numlist[i] - n);
                int diffJ = Math.abs(numlist[j] - n);

                if (diffI > diffJ || (diffI == diffJ && numlist[i] < numlist[j])) {
                    int temp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = temp;
                }
            }
        }

        return numlist;
    }
}
