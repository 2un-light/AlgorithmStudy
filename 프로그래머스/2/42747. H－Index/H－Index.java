import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};

        System.out.println(solution(citations));

    }

    public static int solution(int[] collections) {
        int answer = 0;
        int n = collections.length;

        Arrays.sort(collections);

        for(int i = 0; i < n; i++) {
            int h = n - i;
            if(collections[i] >= h){
                answer = h;
                break;
            }
        }

        return answer;
    }
}
