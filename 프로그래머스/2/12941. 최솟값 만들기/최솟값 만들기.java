import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] A, int[] B) {
        //A, B 오름차순 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        
        for(int i = 0; i < A.length; i++) {
            //A에서 가장 작은 수
            int numA = A[i];
            
            //B에서 가장 큰 수
            int numB = B[B.length - 1 - i];
            
            answer += numA * numB;
        }
        
        return answer;
        
    }
}