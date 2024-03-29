import java.util.Scanner;
public class Main {
    public static final int INT_MIN = Integer.MIN_VALUE;
    public static final int MAX_NUM = 5;

    public static int n, m;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];
    public static int[][] board = new int[MAX_NUM][MAX_NUM];

    public static void clearBoard() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                board[i][j] = 0;
    }

    public static void draw(int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++)
            for(int j = y1; j <=y2; j++)
                board[i][j]++;
    }

    public static boolean checkBoard(){
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < m; j++)
                if(board[i][j] >= 2)
                    return true;
        return false;
    }

    public static boolean overlapped(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        clearBoard();
        draw(x1, y1, x2, y2);
        draw(x3, y3, x4, y4);
        return checkBoard();
    }

    public static int rectSum(int x1, int y1, int x2, int y2) {
        int sumOfNums = 0;
        for(int i = x1; i <= x2; i++)
            for(int j = y1; j <= y2; j++)
                sumOfNums += grid[i][j];
        return sumOfNums;
    }

    public static int findMaxSum(int x1, int y1, int x2, int y2) {
        int maxSum = INT_MIN;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                for(int k = i; k < n; k++)
                    for(int l = j; l < m; l++) {
                        if(!overlapped(x1, y1, x2, y2, i, j, k, l))
                            maxSum = Math.max(maxSum,
                                        rectSum(x1, y1, x2, y2) +
                                        rectSum(i, j, k, l));
                    }
        return maxSum;
    }

    public static int findMaxSum() {
        int maxSum = INT_MIN;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                for(int k = i; k < n; k++)
                    for(int l = j; l < m; l++)
                        maxSum = Math.max(maxSum, findMaxSum(i, j, k, l));
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        System.out.print(findMaxSum());
    }
}