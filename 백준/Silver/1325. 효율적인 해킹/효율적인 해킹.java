import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static int[] hackCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //그래프 초기화
        graph = new ArrayList<>(N + 1);
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프 입력받기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(B).add(A);
        }


        hackCounts = new int[N + 1];
        int maxHack = 0;
        
        //각 컴퓨터를 시작점으로 DFS 탐색하기
        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }

        //최대 해킹 가능한 컴퓨터 수 찾기
        for(int i = 1; i <= N; i++) {
            if(hackCounts[i] > maxHack) {
                maxHack = hackCounts[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            if(hackCounts[i] == maxHack) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
        
    }

    public static void dfs(int startNode, int currentNode) {
        visited[currentNode] = true;
        hackCounts[startNode]++;

        for(int next : graph.get(currentNode)) {
            if(!visited[next]) {
                dfs(startNode, next);
            }
        }

    }


}
