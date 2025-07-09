import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution(scoville, K));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int s : scoville) {
            pq.offer(s);
        }

        int mixCount = 0;

        while(pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int newScoville = first + second * 2;
            pq.offer(newScoville);
            mixCount++;
        }

        return pq.peek() >= K ? mixCount : -1;
    }


}