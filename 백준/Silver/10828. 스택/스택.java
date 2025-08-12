import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] stack;
    public static int index = 0;
    public static String command;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        stack = new int[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                   sb.append(pop()).append("\n");
                   break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "top":
                    sb.append(top()).append("\n");
                    break;
            }


        }

        System.out.println(sb);

    }

    public static void push(int num) {
        stack[index++] = num;
    }

    public static int pop() {
        if(index == 0) return -1;
        return stack[--index];
    }

    public static int size() {
        return index;
    }

    public static int empty() {
        return index == 0 ? 1 : 0;
    }

    public static int top() {
       if (index == 0) return -1;
       return stack[index - 1];
    }

}
