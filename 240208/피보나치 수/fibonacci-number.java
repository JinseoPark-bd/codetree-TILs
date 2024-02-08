import java.util.*;
import java.io.*;
public class Main {
    /**
    dp : 큰 문제에 대한 답을 얻기 위해 동일한 문제이지만 크기가 더 작은 문제들을 먼저 해결한 뒤, 그 결과들을 이용해 큰 문제를 비교적 간단하게 해결하는 기법
    메모이제이션 : 값을 기록하고, 그 기록한 값을 참조하는 것
    Tabulation : 아래에서 값을 채워 나가기 때문에 바텀업 방식 (Bottom-Up Approach) 라고 부릅니다. 바텀업 방식이 약간 더 빠릅니다.
    **/
    public static int N;
    public static final int MAX_N = 46;
    public static int[] dp = new int[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= N; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.print(dp[N]);
    }
}