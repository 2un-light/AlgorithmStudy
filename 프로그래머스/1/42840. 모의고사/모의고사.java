import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};

        System.out.println(Arrays.toString(solution(answers)));
    }

    public static int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];
        for(int i = 0; i < answers.length; i++) {
            if(student1[i % student1.length] == answers[i]) score[0]++;
            if(student2[i % student2.length] == answers[i]) score[1]++;
            if(student3[i % student3.length] == answers[i]) score[2]++;
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(score[i] == maxScore) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();

    }
}
