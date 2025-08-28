import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //종이 입력 받기
        paper = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);
        System.out.println(white);
        System.out.println(blue);

    }

    public static void cut(int x, int y, int size) {
        if(check(x, y, size)) {
            if(paper[x][y] == 0) {
                white++;
            }else {
                blue++;
            }
            return;
        }

        int half = size / 2;

        cut(x, y, half);
        cut(x + half, y, half);
        cut(x, y + half, half);
        cut(x + half, y + half, half);


    }

    public static boolean check(int x, int y, int size) {
        int color = paper[x][y];
        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }



}
