import java.util.Scanner;
public class Main {
    static int n;
    static final int MAX_NUM = 20;
    static int[][] arr = new int[MAX_NUM][MAX_NUM];
    
    public static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static int getScore(int x, int y, int w, int h) {
        int[] dx = new int[]{-1,-1,1,1};
        int[] dy = new int[]{1,-1,-1,1};
        int[] moveNum = new int[]{w,h,w,h};
        int sum = 0;

        for(int d = 0; d < 4; d++) {
            for(int q = 0; q < moveNum[d]; q++) {
                x += dx[d];
                y += dy[d];
                if(!inRange(x,y)) return 0;
                sum += arr[x][y];
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int w = 1; w < n; w++) {
                    for(int h = 1; h < n; h++) {
                        ans = Math.max(ans,getScore(i,j,w,h));
                    }
                }
            }
        }

        System.out.print(ans);
    }
}