import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] money) {
        
        int[] coinDp = new int[n + 1];
        coinDp[0] = 1;
        
        for(int coin : money) {
            for(int i = 1; i <= n; i++){
                if(i >= coin) {
                    coinDp[i] = coinDp[i - coin] + coinDp[i];
                }
            }   
        }
        
        
        return coinDp[n];
    }
}