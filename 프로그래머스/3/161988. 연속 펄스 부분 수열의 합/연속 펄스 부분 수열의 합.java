import java.util.*;
import java.io.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        //-1로 시작하는 배열
        int[] minusSequence = new int[sequence.length];
        
        //1로 시작하는 배열
        int[] plusSequence = new int[sequence.length];
        
        //배열 만들기
        int i = 0;
        for(int s : sequence) {
            if(i % 2 == 0) {
                minusSequence[i] = sequence[i] * -1;
                plusSequence[i] = sequence[i] * 1;
            }else {
                minusSequence[i] = sequence[i] * 1;
                plusSequence[i] = sequence[i] * -1;
            }
            i++;
        }
        
        long result1 = getMaxSubArray(minusSequence);
        long result2 = getMaxSubArray(plusSequence);   
        
        return Math.max(result1, result2);
    }
    
    //dp 이용
    private long getMaxSubArray(int[] arr) {
        long max = arr[0];
        long current = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            current = Math.max(current + arr[i], arr[i]);
            max = Math.max(max, current);
        }
        
        return max;
    }
}