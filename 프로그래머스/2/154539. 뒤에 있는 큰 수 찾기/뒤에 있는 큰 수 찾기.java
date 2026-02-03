import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Arrays.fill(result, -1);
        
        Stack<Integer> stack = new Stack();
        
        for(int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int idx = stack.pop();
                result[idx] = numbers[i];
            }
            stack.push(i);
        }
        
        return result;
    }
}