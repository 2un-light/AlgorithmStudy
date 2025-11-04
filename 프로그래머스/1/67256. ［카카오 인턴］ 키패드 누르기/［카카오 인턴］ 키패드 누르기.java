import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        Map<Integer, int[]> pos = new HashMap<>();
        pos.put(1, new int[]{0, 0});
        pos.put(2, new int[]{0, 1});
        pos.put(3, new int[]{0, 2});
        pos.put(4, new int[]{1, 0});
        pos.put(5, new int[]{1, 1});
        pos.put(6, new int[]{1, 2});
        pos.put(7, new int[]{2, 0});
        pos.put(8, new int[]{2, 1});
        pos.put(9, new int[]{2, 2});
        pos.put(0, new int[]{3, 1});
        
        int[] leftPos = {3, 0}; //*
        int[] rightPos = {3, 2}; //#
        
        for(int num : numbers) {
            int[] numPos = pos.get(num);
            
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                leftPos = numPos;
            }else if(num == 3 || num == 6 || num == 9) {
                sb.append("R");
                rightPos = numPos;
            }else {
                
                int leftDist = Math.abs(leftPos[0] - numPos[0]) + Math.abs(leftPos[1] - numPos[1]);
                int rightDist = Math.abs(rightPos[0] - numPos[0]) + Math.abs(rightPos[1] - numPos[1]);
                
                if(leftDist < rightDist) {
                    sb.append("L");
                    leftPos = numPos;
                }else if(leftDist > rightDist) {
                    sb.append("R");
                    rightPos = numPos;
                }else if(leftDist == rightDist) {
                    if(hand.equals("right")) {
                        sb.append("R");
                         rightPos = numPos;
                    }else {
                        sb.append("L");
                        leftPos = numPos;
                    }
                
                }
            }
        }
        
        return sb.toString();
        
    }
}