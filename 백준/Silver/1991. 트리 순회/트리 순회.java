import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        char left, right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    static Map<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.put(root, new Node(left, right));
        }

        preorder('A');
        System.out.println();
        inorder('A');
        System.out.println();
        postorder('A');

    }

    static void preorder(char node) {
        if(node == '.') return;
        System.out.print(node);
        preorder(tree.get(node).left);
        preorder(tree.get(node).right);
    }

    static void inorder(char node) {
        if(node == '.') return;
        inorder(tree.get(node).left);
        System.out.print(node);
        inorder(tree.get(node).right);
    }

    static void postorder(char node) {
        if (node == '.') return;
        postorder(tree.get(node).left);
        postorder(tree.get(node).right);
        System.out.print(node);
    }

}
