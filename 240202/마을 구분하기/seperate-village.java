import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static final int MAX_N = 25;
    static int[][] map = new int[MAX_N][MAX_N];
    static int[][] visited = new int[MAX_N][MAX_N];
    static int villCnt = 0;
    static int peopleCnt = 0;
    static ArrayList<Integer> cntList = new ArrayList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }


    public static void DFS(int x, int y) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        if(!inRange(x,y)) return;
        if(map[x][y] == 0 || visited[x][y] == 1) return;

        visited[x][y] = 1;
        peopleCnt++;

        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            DFS(newX, newY);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                DFS(i,j);
                if(peopleCnt > 0) {
                    villCnt++;
                    cntList.add(peopleCnt);
                    peopleCnt = 0;
                }
            }
        }

        Collections.sort(cntList);
        
        System.out.println(villCnt);
        for(int i = 0; i < cntList.size(); i++) {
            System.out.println(cntList.get(i));
        }
    
    }
}