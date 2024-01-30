import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static int n;
    public static int count = 0;
    public static ArrayList<Integer> list = new ArrayList<>();
    public static int answer = 0;
    /**
    * 1이상 4이하의 수로만
    * 아름다운수 : 숫자가 숫자개수만큼 연달아 있는 경우
    * n = 2  1+1
    **/
    public static void beautifulNum(int s) {
        answer += s;

        if(answer == n){
            count++;
            answer -= s;
            return;
        }

        if(answer > n) {
            answer -= s;
            return;
        }

        for(int i = 1; i <= n; i++) {
            beautifulNum(i);
        }
        
        answer -= s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        beautifulNum(0);
        System.out.print(count);
    }
}