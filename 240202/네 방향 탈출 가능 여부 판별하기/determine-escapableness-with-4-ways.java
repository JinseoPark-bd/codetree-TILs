import java.io.*;
import java.util.*;
class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
public class Main {
    static int n, m;
    static final int MAX_INT = 100;
    static int[][] map = new int[MAX_INT][MAX_INT];
    static int[][] visited = new int[MAX_INT][MAX_INT];
    static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(map[x][y] == 0 || visited[x][y] == 1) return false;
        return true;
    }

    public static void push(int x, int y) {
        visited[x][y] = 1;
        q.add(new Pair(x,y));
    }

    public static void BFS() {
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x, y = curr.y;

            for(int i = 0; i < 2; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(canGo(newX, newY)) {
                    push(newX, newY);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        push(0,0);
        BFS();

        if(visited[n-1][m-1] == 1) System.out.print(0);
        else System.out.print(1);
    }
}