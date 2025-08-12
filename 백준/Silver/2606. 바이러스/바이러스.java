import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int v, e;
    public static int[] parent;

    public static int getParent(int x) {
        if(parent[x] == x) return x;
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

        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        parent = new int[v + 1];

        for(int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            unionParent(a, b);
        }

        for(int i = 1; i <= v; i++) {
            getParent(i);
        }

        int cnt = 0;
        for(int i = 2; i <= v; i++) {
            if(parent[i] == 1) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
