import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            switch(s) {
                case "push_back" :
                    list.add(sc.nextInt());
                    break;
                case "pop_back" :
                    list.remove(list.size()-1);
                    break;
                case "size" :
                    System.out.println(list.size());
                    break;
                case "get" :
                    System.out.println(list.get(sc.nextInt()-1));
                    break;
            }
        }
    }
}