import java.util.Scanner;
public class Main {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        System.out.println(fibbo(n));
    
    }

    public static int fibbo(int n) {

    
        if(dp[n] != 0) return dp[n];

        return dp[n] = fibbo(n - 1) + fibbo(n - 2);
        
    }
}