import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int time = 0;
        int index = 0;
        int total = 0;

        int count = 0;

        while(count < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= time) {
                pq.offer(jobs[index]);
                index++;
            }

            if(!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1];
                total += time - job[0];
                count++;
            }else {
                time = jobs[index][0];
            }
        }
        return total / jobs.length;
    }


}
