import java.util.*;
public class Main {
    public static int n;
    public static final int MAX_N = 1000;
    public static int[] dp = new int[MAX_N+1];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++)
            dp[n] = dp[i-1] + dp[i-2];
        System.out.print(dp[n]);
    }
}