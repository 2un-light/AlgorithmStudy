import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String baseN = Integer.toString(n, k);
        
        //0을 기준으로 분리
        String[] results = baseN.split("0");
        for(String result : results) {
            if(result.isEmpty()) continue;
            long num = Long.parseLong(result);
            if(isPrime(num)) {
                answer++;
            }
        }
        
        
        return answer;
    }
    
    
    //소수 판별 프로그램
    public boolean isPrime(long n) {
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        
        for(long i = 3; i * i <= n; i += 2) {
            if(n % i == 0) {
                return false;
            }
        }
        
        return true;
        
    }
}