import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            int s = 1;
            for(int j = 0; j < n-1; j++) {
                if(arr[i][j] == arr[i][j+1]) s++;
                else {
                    s = 1;
                    continue;
                }

                if(s == m) {
                    answer++;
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            int s = 1;
            for(int j = 0; j < n-1; j++) {
                if(arr[j][i] == arr[j+1][i]) s++;
                else {
                    s = 1;
                    continue;
                }

                if(s >= m) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}