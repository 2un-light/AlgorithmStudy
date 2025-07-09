import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();

        int time = 0;
        int totalWeight = 0;
        int idx = 0;

        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while(idx < truck_weights.length) {
            time++;
            totalWeight -= bridge.poll();

            if(totalWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                totalWeight += truck_weights[idx];
                idx++;
            }else {
                bridge.offer(0);
            }
        }

        return time + bridge_length;
    }
}
