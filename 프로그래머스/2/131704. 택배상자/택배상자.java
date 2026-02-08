import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> auxContainer = new Stack();
        
        int box = 1;
        for(int boxNum : order) {
            while(box <= order.length && box < boxNum) {
                auxContainer.push(box);
                box++;
            }
            
            if(box == boxNum) {
                answer++;
                box++;
            }else if(!auxContainer.isEmpty() && auxContainer.peek() == boxNum) {
                auxContainer.pop();
                answer++;
            }else {
                break;
            }
        }
        
        return answer;
    }
}