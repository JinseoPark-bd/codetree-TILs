import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static final int MAX_NUM = 100;
    static int[][] visited = new int[MAX_NUM][MAX_NUM];
    static int[][] map = new int[MAX_NUM][MAX_NUM];

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(visited[x][y] == 1 || map[x][y] == 0) return false;
        return true;
    }

    public static void DFS(int x, int y) {
        int[] dx = new int[] {1, 0};
        int[] dy = new int[] {0, 1};

        visited[x][y] = 1;

        for(int i = 0; i < 2; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(canGo(newX, newY)) {
                DFS(newX, newY);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0,0);

        if(visited[n-1][m-1] == 1) System.out.println(1);
        else System.out.println(0);
    }
}