import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    private int nodeA;
    private int nodeB;
    private int distance;
    
    public Edge(int nodeA, int nodeB, int distance) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.distance = distance;
    }
    
    public int getNodeA() {
        return this.nodeA;
    }
    
    public int getNodeB() {
        return this.nodeB;
    }
    
    public int getDistance() {
        return this.distance;
    }
    
    public int compareTo(Edge o) {
        if(this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}

class Solution {
    static int[] parent;
    static ArrayList<Edge> edges = new ArrayList<>();
    static int result = 0;
    
    public int findParent(int x) {
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }
    
    public void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        
        //부모 테이블 자기 자신으로 초기화
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < costs.length; i++) {
            int[] costInfo = costs[i];
            int nodeA = costInfo[0];
            int nodeB = costInfo[1];
            int cost = costInfo[2];
            
            edges.add(new Edge(nodeA, nodeB, cost));
        }
        
        Collections.sort(edges);
        
        for(int i = 0; i < edges.size(); i++) {
            int cost = edges.get(i).getDistance();
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            
            if(findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }
        
        return result;
    }
}