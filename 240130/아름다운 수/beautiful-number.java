import java.util.*;
import java.io.*;
public class Main {
    public static int n;
    public static int count = 0;
    public static int[] arr;

    public static void beautifulNum(int num) {
        if(num == n) count++;
        else {
            for(int i = 1; i <= 4; i++) {
                if(num + i > n) return;
                else {
                    for(int j = 0; j < i; j++) {
                        arr[num+j] = i;
                    }
                    beautifulNum(num+i);
                }
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        beautifulNum(0);
        System.out.print(count);
    }
}