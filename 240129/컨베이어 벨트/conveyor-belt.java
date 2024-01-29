import java.util.Scanner;
public class Main {
    public static int n, t;
    public static final int MAX_INT = 200;
    public static int[][] arr = new int[2][MAX_INT];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < t%(2*n); i++) {
            moveArr1();
        }
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void moveArr1() {
        int temp1 = arr[0][n-1];
        int temp2 = arr[1][n-1];
        
        for(int i = 0; i < 2; i++) {
            for(int j = n-1; j >= 1; j--) {
                arr[i][j] = arr[i][j-1];
            }
        }
        arr[0][0] = temp2;
        arr[1][0] = temp1;
    }
}