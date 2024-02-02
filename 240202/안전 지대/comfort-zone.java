import java.io.*;
import java.util.*;
public class Main {
    static int N, M, MAX_K;
    static final int MAX_NUM = 50;
    static int cnt = 0;
    static int[][] map = new int[MAX_NUM][MAX_NUM];
    static int[][] visited = new int[MAX_NUM][MAX_NUM];

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    public static boolean canGo(int x, int y, int k) {
        if(!inRange(x,y)) return false;
        if(visited[x][y] == k || map[x][y] <= k) return false;
        return true;
    }
    
    public static void DFS(int x, int y, int k) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        
        if(canGo(x,y,k)) {
            visited[x][y] = k;
            cnt++;
            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                DFS(newX,newY,k);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAX_K = 0;
        ArrayList<Integer> list = new ArrayList<>();
        int maxVill = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] =Integer.parseInt(st.nextToken());
                MAX_K = Math.max(MAX_K, map[i][j]);
            }
        }

        ArrayList<Integer> maxList = new ArrayList<>();
        maxList.add(0);

        for(int k = 1; k <= MAX_K; k++) {
            int maxCnt = 0;
            int minK = MAX_K;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    DFS(i,j,k);
                    if(cnt > 0) {
                        maxCnt++;
                    }
                    cnt = 0;
                }
            }
            maxVill = Math.max(maxVill, maxCnt);
            maxList.add(maxCnt);
        }
        int MIN_K = maxList.indexOf(maxVill) == 0 ? 1 : maxList.indexOf(maxVill);
        System.out.print(MIN_K+" "+maxVill);
    }
}