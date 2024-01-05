import java.util.Scanner;
public class Main { 
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int max = 0;
        int i = 0;
        int j = 0;
        while(i+2 < N) {
            while(j+2 < N) {
                int sumMax = 0;
                for(int k = i; k < 3; k++) {
                    for(int l = j; l < 3; l++) {
                        sumMax += arr[k][l];
                    }
                }
                max = Math.max(max,sumMax);
                j++;
            }
            i++;
        }
        System.out.println(max);
    }
}