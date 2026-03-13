import java.util.*;

class Solution {
    
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        
        dfs(numbers, "", visited);
        
        int count = 0;
        
        for(int num : set) {
            if(isPrime(num)) count++;
        }
        
        return count;
    }
    
    void dfs(String numbers, String current, boolean[] visited) {
        
        if(!current.equals("")) {
            set.add(Integer.parseInt(current));
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }
    
    
    boolean isPrime(int num) {
        if(num < 2) return false;
        
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) return false;
        }
        
        return true;
    }
}