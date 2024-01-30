import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static int K, N;
    public static ArrayList<Integer> answer = new ArrayList<>();
    public static void print() {
        for(int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i)+ " ");
        }
        System.out.println();
    }

    public static void choose(int currNum) {
        if(currNum == N+1) {
            print();
            return;
        }
        for(int i = 1; i <= K; i++) {
            answer.add(i);
            choose(currNum+1);
            answer.remove(answer.size()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        N = sc.nextInt();
        choose(1);
    }
}