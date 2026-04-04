import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int count = 0;
        int bIdx = 0;
        
        for(int i = 0; i < A.length; i++) {
            while(bIdx < B.length) {
                if(B[bIdx] > A[i]) {
                    count++;
                    bIdx++;
                    break;
                }
                bIdx++;
            }
        }
        
        return count;
    }
}