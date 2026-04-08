import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Please write your code here.

        int N = Integer.parseInt(br.readLine());
        printNLine(N);
    
    }

    public static void printNLine(int n) {
        for(int i = 0; i < n; i++) {
            System.out.println("12345^&*()_");
        }
    }
}