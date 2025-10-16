import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int[] parent = new int[n];
        
        //부모 테이블 자기 자신으로 초기화
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) {
                    unionParent(parent, i, j);
                }
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) cnt++;
        }
        
        return cnt;
        

    }
    
    private int findParent(int[] parent, int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent, parent[x]);
    }
    
    private void unionParent(int[] parent, int a, int b) {
        int rootA = findParent(parent, a);
        int rootB = findParent(parent, b);
        
        if(rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;
    }
    
    
    
    
}