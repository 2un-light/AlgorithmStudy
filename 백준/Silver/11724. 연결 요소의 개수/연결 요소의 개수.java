import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static int[] parent;

    public static int getParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = getParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            unionParent(nodeA, nodeB);
        }

       for(int i = 1; i <= n; i++) {
           getParent(i);
       }

       Set<Integer> set = new HashSet<>();
       for(int i = 1; i <= n; i++) {
           set.add(parent[i]);
       }

        System.out.println(set.size());

    }
}
