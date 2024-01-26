import java.util.Scanner;
public class Main {
    public static int n, m;
    public static final int MAX_INT = 20;
    public static int[][] board = new int[MAX_INT][MAX_INT];

    public static int maxRec(int x1, int y1, int x2, int y2) {
        int count = 0;
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(board[i][j] < 0) {
                    return 0;
                }
                else count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int ans = 0;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                board[i][j] = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                for(int w = ; w < n; w++)
                    for(int h = j; j < m; h++) {
                        int maxSize = maxRec(i, j, w, h);
                        ans = Math.max(ans,maxSize);
                    }

        if(ans < 0) System.out.print(-1);
        else System.out.print(ans);
    }
}