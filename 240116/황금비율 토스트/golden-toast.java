import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
public class Main {
    public static int n,m;
    public static String s;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.next();
        LinkedList<Character> l = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            l.add(s.charAt(i));
        }

        ListIterator<Character> it = l.listIterator(l.size());

        while(m-- > 0) {
            char command = sc.next().charAt(0);

            switch(command) {
                case 'L' :
                    if(it.hasPrevious()) it.previous();
                    break;
                case 'P' :
                    char c = sc.next().charAt(0);
                    it.add(c);
                    break;
                case 'R' :
                    if(it.hasNext()) it.next();
                    break;
                case 'D' :
                    if(it.hasNext()) {
                        it.next();
                        it.remove();
                    }
            }
        }

        it = l.listIterator();
        while(it.hasNext())
            System.out.print(it.next());
    }
}