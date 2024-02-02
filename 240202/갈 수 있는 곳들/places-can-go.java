import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    } 
}

public class Main {
    static int n, k;
    static final int MAX_N = 100;
    static int cnt = 0;
    static int[][] map = new int[MAX_N][MAX_N];
    static int[][] visited = new int[MAX_N][MAX_N];
    static Queue<Pair> q = new LinkedList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(map[x][y] == 1 || visited[x][y] == 1) return false;
        return true;
    }

    public static void push(int x, int y) {
        if(canGo(x, y)) {
            visited[x][y] = 1;
            cnt++;
            q.add(new Pair(x, y));
        }
    }

    public static void BFS() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.x;
            int y = curr.y;

            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(canGo(newX, newY))
                    push(newX, newY);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            push(x-1, y-1);
            BFS();
        }

        System.out.print(cnt);
    }
}