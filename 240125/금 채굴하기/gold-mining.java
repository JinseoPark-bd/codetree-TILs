import java.util.Scanner;
public class Main {
    /**
    * 1. 완전 탐색
    * 2. 1000 m/s
    **/
    public static int n,m;
    public static final int MAX_NUM = 20;
    public static int[][] grid = new int[MAX_NUM][MAX_NUM];

    // 주어진 k에 대하여 마름모의 넓이를 반환
    public static int getArea(int k) {
        return k*k + (k+1)*(k+1);
    }

    // 주어진 k에 대하여 채굴 가능한 금의 개수를 반환
    public static int getNumOfGold(int row, int col, int k){
        int numOfGold = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(Math.abs(row-i)+Math.abs(col-j) <= k)
                    numOfGold += grid[i][j];
            }
        }
        return numOfGold;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxGold = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        
        for(int i = 0; i< n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k <= 2*(n-1); k++) {
                    int numOfGold = getNumOfGold(i,j,k);
                    
                    if(numOfGold * m >= getArea(k))
                        maxGold = Math.max(maxGold, numOfGold);
                }
            }
        }

        System.out.print(maxGold);
    }
}